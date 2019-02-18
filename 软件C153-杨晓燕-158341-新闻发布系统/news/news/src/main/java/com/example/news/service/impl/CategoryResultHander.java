package com.example.news.service.impl;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authou YXY
 * @Date 2018/11/16 14:49
 */
public class CategoryResultHander implements ResultHandler {
    @SuppressWarnings("rawtypes")
    private final Map mappedResult = new HashMap();

    @SuppressWarnings("unchecked")
    @Override
    public void handleResult(ResultContext resultContext) {
        @SuppressWarnings("rawtypes")
        Map map = (Map) resultContext.getResultObject();
        mappedResult.put(map.get("id"),map.get("category"));

    }

    @SuppressWarnings("rawtypes")
    public Map getMappedResult() {
        return mappedResult;
    }


}
