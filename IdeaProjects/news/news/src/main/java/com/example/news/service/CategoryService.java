package com.example.news.service;

import com.example.news.domain.Category;
import com.example.news.domain.News;

import java.util.List;
import java.util.Map;

/**
 * @Authou YXY
 * @Date 2018/11/14 12:54
 */
public interface CategoryService {
    Map<Integer,String> findCategory();
    List<News> findNewsByCategory(String category);
    List<Category> findCategoryName();
    List<Category> findAllCategory();
    Category findCategoryId(String category);
}
