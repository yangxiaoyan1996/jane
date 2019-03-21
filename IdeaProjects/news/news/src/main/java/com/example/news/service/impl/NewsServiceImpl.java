package com.example.news.service.impl;

import com.example.news.dao.NewsDao;
import com.example.news.domain.News;
import com.example.news.domain.NewsParam;
import com.example.news.mysql.PagedResult;
import com.example.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authou YXY
 * @Date 2018/11/14 22:59
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public PagedResult<News> queryAllByPage(NewsParam param){
        return newsDao.queryAllByPage(param);
    }

    @Override
    public List<News> findNewsByCategoryId(Integer categoryId) {
        System.out.println("+++++++++++++");
        return newsDao.findNewsByCategoryId(categoryId);
    }

    @Override
    public PagedResult<News> queryNewsByPage(NewsParam param) {
        return newsDao.selectPagingNewsByPage(param);
    }

    @Override
    public News getById(Integer id){
        return newsDao.getById(id);
    }

    @Override
    public int delNews(int id) {
       return newsDao.delNews(id);

    }

    @Override
    public int updNews(News news) {
        System.out.println(">>>>>>>>>>>>updService");
         return newsDao.updNews(news);

    }

    @Override
    public int addNews(News news) {
        System.out.println(">>>>>>>>>>>>addService");
        return newsDao.addNews(news);

    }
}
