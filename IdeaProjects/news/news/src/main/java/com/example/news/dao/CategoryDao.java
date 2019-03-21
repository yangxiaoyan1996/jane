package com.example.news.dao;

import com.example.news.domain.Category;
import com.example.news.domain.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Authou YXY
 * @Date 2018/11/14 10:49
 */
@Repository
public interface CategoryDao {
    Map<Integer,String> findCategory();
    List<News> findNewsByCategory(String category);
    List<Category> findAllCategory();
    Category findCategoryId(String category);
}
