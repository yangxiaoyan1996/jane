package com.example.news.mysql;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @param:
 * @return:
 * @auther: MLC
 * @date: 2018/9/10 11:49
 */

/**
 * @Intercepts 说明是一个拦截器
 * @Signature 拦截器的签名
 * type 拦截的类型 四大对象之一( Executor,ResultSetHandler,ParameterHandler,StatementHandler)
 * method 拦截的方法
 * args 参数
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class DialectInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object target = invocation.getTarget();
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Object parameterObject = boundSql.getParameterObject();
        String origSql = boundSql.getSql().trim();

        int count = -1;
        if (isPage(mappedStatement.getId(), origSql, parameterObject)) {
            PagedParam param = (PagedParam) parameterObject;
            if (isCount()) {
                count = count(target, mappedStatement, boundSql);
            }

            String pagedSql = createPagedSql(origSql, param.getP(), param.getSize());
            BoundSql pagedBoundSql = copyFromBoundSql(mappedStatement, boundSql, pagedSql);
            MappedStatement pagedMappedStatement = copyFromMappedStatement(mappedStatement, pagedBoundSql);
            invocation.getArgs()[0] = pagedMappedStatement;
        }

        Object pagedList = invocation.proceed();
        if (count >= 0) {
            PagedParam param = (PagedParam) parameterObject;
            int totalPages = PagingUtils.getTotalPages(count, param.getSize());
            if (pagedList instanceof PagedResult) {
                PagedResult result = (PagedResult) pagedList;
                result.setTotalPages(totalPages);
                result.setTotalCount(count);
            } else {
                PagedResult result = new PagedResult<>();
                result.setTotalPages(totalPages);
                result.setTotalCount(count);
                result.setData((List)pagedList);
                return result;
            }
        }

        return pagedList;
    }

    private MappedStatement copyFromMappedStatement(MappedStatement mappedStatement, final BoundSql pagedBoundSql) {
        MappedStatement.Builder builder = new MappedStatement.Builder(mappedStatement.getConfiguration(), mappedStatement.getId(), new SqlSource() {
            public BoundSql getBoundSql(Object o) {
                return pagedBoundSql;
            }
        }, mappedStatement.getSqlCommandType());

        builder.resource(mappedStatement.getResource());
        builder.fetchSize(mappedStatement.getFetchSize());
        builder.statementType(mappedStatement.getStatementType());
        builder.keyGenerator(mappedStatement.getKeyGenerator());
        if (null != mappedStatement.getKeyProperties() && mappedStatement.getKeyProperties().length > 0) {
            builder.keyProperty(mappedStatement.getKeyProperties()[0]);
        }

        builder.timeout(mappedStatement.getTimeout());
        builder.parameterMap(mappedStatement.getParameterMap());
        builder.resultMaps(mappedStatement.getResultMaps());
        builder.resultSetType(mappedStatement.getResultSetType());
        builder.cache(mappedStatement.getCache());
        builder.flushCacheRequired(mappedStatement.isFlushCacheRequired());
        builder.useCache(mappedStatement.isUseCache());

        return builder.build();
    }

    private String createPagedSql(String origSql, Integer pageNo, Integer pageSize) {
        StringBuilder sb = new StringBuilder();
        sb.append(origSql);
        sb.append(" LIMIT ");
        if (pageNo > 1) {
            sb.append((pageNo - 1) * pageSize);
            sb.append(", ");
        }
        sb.append(pageSize);

        return sb.toString();
    }

    private int count(Object target, MappedStatement mappedStatement, BoundSql boundSql) throws SQLException {
        Connection connection = getConnection(target, mappedStatement.getStatementLog());
        String countSql = createCountSql(boundSql.getSql());

        return executeCountSql(connection, countSql, mappedStatement, boundSql);
    }

    private int executeCountSql(Connection connection, String countSql, MappedStatement mappedStatement, BoundSql boundSql) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;
        try {
            BoundSql countBoundSql = copyFromBoundSql(mappedStatement, boundSql, countSql);
            ParameterHandler handler = mappedStatement.getConfiguration().newParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);

            ps = connection.prepareStatement(countSql);
            handler.setParameters(ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return count;
    }

    private BoundSql copyFromBoundSql(MappedStatement mappedStatement, BoundSql boundSql, String sql) {
        BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }
        return newBoundSql;
    }

    private String createCountSql(String sql) {
        return "SELECT COUNT(*) FROM (" + sql + ") AS A";
    }

    private Connection getConnection(Object target, Log statementLog) throws SQLException {
        Executor exe = (Executor) target;
        Connection connection = exe.getTransaction().getConnection();
        if (statementLog.isDebugEnabled()) {
            return ConnectionLogger.newInstance(connection, statementLog, 0);
        } else {
            return connection;
        }
    }

    private boolean isCount() {
        return true;
    }

    private boolean isPage(String id, String origSql, Object parameterObject) {
        if (id.matches(".+ByPage$") && parameterObject instanceof PagedParam && isSelect(origSql)) {
            return true;
        }
        return false;
    }

    private boolean isSelect(String origSql) {
        String trimSql = origSql.trim();
        int index = trimSql.toLowerCase().indexOf("select");
        return index == 0;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
