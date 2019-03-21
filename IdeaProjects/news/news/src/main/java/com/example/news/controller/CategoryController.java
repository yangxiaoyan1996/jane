package com.example.news.controller;

import com.example.news.domain.Category;
import com.example.news.domain.News;
import com.example.news.service.CategoryService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Authou YXY
 * @Date 2018/11/14 13:00
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category")
    public Map<Integer, String> findCategory(){
        System.out.println("============");
        return categoryService.findCategory();
    }

    @GetMapping(value = "/findNewsByCategory")
    public List<News> findNewsByCategory(String category){
        System.out.println(">>>>>>>>>"+category);
        return categoryService.findNewsByCategory(category);
    }

    @GetMapping(value = "/findCategoryName")
    public List<Category> findCategoryName(){
        return categoryService.findCategoryName();

    }

    @GetMapping(value = "/findAllCategory")
    public List<Category> findAllCategory(){

        return initData();
//        return categoryService.findAllCategory();
    }

    private List<Category> initData(){
        List<Category> categories = new ArrayList<>();
        Category category1 = new Category();
        category1.setId(1);
        category1.setCategory("娱乐");
        Category category2 = new Category();
        category2.setId(2);
        category2.setCategory("军事");
        categories.add(category1);
        categories.add(category2);
        return categories;
    }

}
