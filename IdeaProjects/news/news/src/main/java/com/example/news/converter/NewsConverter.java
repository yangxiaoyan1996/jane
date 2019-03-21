package com.example.news.converter;

import com.example.news.domain.News;
import com.example.news.domain.QueryNewsPageResponse;
import com.example.news.mysql.PagedResult;

/**
 * @Authou YXY
 * @Date 2018/11/20 15:26
 */
public class NewsConverter {
    public static QueryNewsPageResponse<News> toQueryNewsPageResponse(PagedResult<News> newsPagedResult){
        QueryNewsPageResponse<News> respData  = new QueryNewsPageResponse<>();
        respData.setNewsList(newsPagedResult.getData());
        respData.setP(newsPagedResult.getTotalPages());
        respData.setSize(newsPagedResult.getTotalCount());
        return respData;
    }
}
