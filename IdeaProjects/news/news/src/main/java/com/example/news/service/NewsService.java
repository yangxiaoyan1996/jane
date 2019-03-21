package com.example.news.service;

import com.example.news.domain.News;
import com.example.news.domain.NewsParam;
import com.example.news.mysql.PagedParam;
import com.example.news.mysql.PagedResult;

import java.util.List;

/**
 * @Authou YXY
 * @Date 2018/11/13 17:48
 */
public interface NewsService {
    PagedResult<News> queryAllByPage(NewsParam param);
    List<News> findNewsByCategoryId(Integer categoryId);
    PagedResult<News> queryNewsByPage(NewsParam param);
    News getById(Integer id);
    int delNews(int id);
    int updNews(News news);
    int addNews(News news);
}
