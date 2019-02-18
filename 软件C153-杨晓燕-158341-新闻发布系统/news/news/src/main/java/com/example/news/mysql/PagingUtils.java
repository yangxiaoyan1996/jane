package com.example.news.mysql;


import java.util.Collections;
import java.util.List;

/**
 * 功能描述: 分页工具
 *
 * @param:
 * @return:
 * @auther: MLC
 * @date: 2018/9/17 18:32
 */
public class PagingUtils {

    public static <T> PagedResult<T> getPagedResult(List<T> list, int pageNo, int limit) {
        if (list == null) {
            return createEmptyPageResult();
        }

        List<T> pagedList = getPagedList(list, pageNo, limit);
        int totalCount = list.size();
        int totalPages = getTotalPages(totalCount, limit);

        return createPagedResult(totalPages, totalCount, pagedList);
    }

    public static <T> List<T> getPagedList(List<T> list, int pageNo, int limit) {
        if (list == null) {
            return Collections.emptyList();
        }

        return list.subList((pageNo - 1) * limit, pageNo * limit);
    }

    public static int getTotalPages(int recordTotal, int limit) {
        int maxPageNo = recordTotal / limit;
        if (recordTotal % limit > 0) {
            maxPageNo++;
        }

        return maxPageNo;
    }

    public static <T> PagedResult<T> createPagedResult(int totalPages, int totalCount, List<T> data) {
        PagedResult<T> result = new PagedResult<T>();
        result.setTotalPages(totalPages);
        result.setTotalCount(totalCount);
        result.setData(data);

        return result;
    }

    public static <T> PagedResult<T> createEmptyPageResult() {
        return new PagedResult<T>();
    }

}
