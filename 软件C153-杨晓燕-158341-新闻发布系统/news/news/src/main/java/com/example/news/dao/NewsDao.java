package com.example.news.dao;

import com.example.news.domain.News;
import com.example.news.domain.NewsParam;
import com.example.news.mysql.PagedResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Authou YXY
 * @Date 2018/11/13 17:36
 */
@Repository
public interface NewsDao {
    PagedResult<News> queryAllByPage(NewsParam param);
    List<News> findNewsByCategoryId(Integer categoryId);
    PagedResult<News> selectPagingNewsByPage(NewsParam param);
    int delNews(int id);
    int updNews(News news);
    int addNews(News news);
    News getById(Integer id);
}
