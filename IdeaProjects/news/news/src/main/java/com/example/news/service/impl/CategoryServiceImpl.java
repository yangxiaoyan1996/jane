package com.example.news.service.impl;

import com.example.news.dao.CategoryDao;
import com.example.news.domain.Category;
import com.example.news.domain.News;
import com.example.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Authou YXY
 * @Date 2018/11/14 12:57
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Map<Integer, String> findCategory() {
        Map<Integer, String> cateMap = categoryDao.findCategory();
        System.out.println("++++++++++++");
        Map<Integer, String> resultMap = new HashMap<>();
        Integer id = null;
        String cate = null;
        for (Map.Entry<Integer, String> entry : cateMap.entrySet()) {
//            if ("ID".equals((entry.getKey()))){
//                id = entry.getValue().;
//            }else if ("CATEGORY".equals(entry.getKey())){
//                cate = entry.getValue();
//            }
            System.out.println(entry.getKey() + entry.getValue());

        }
        resultMap.put(id, cate);
        return resultMap;
    }

    @Override
    public List<News> findNewsByCategory(String category) {

        return categoryDao.findNewsByCategory(category);
    }

    /**
     * 获取分类的类型名称
     *
     * @return
     */

    @Override
    public List<Category> findCategoryName() {
        List<Category> categoryListAll = categoryDao.findAllCategory();
        int categoryCount = categoryListAll.size();
        List listName = new ArrayList<>();
        for (int i = 0; i < categoryCount; i++) {
            String categoryName = categoryListAll.get(i).getCategory();
            listName.add(categoryName);
        }
        return listName;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }

    /**
     * 获取该类型对应的ID
     *
     * @return
     */

    @Override
    public Category findCategoryId(String category) {
        return categoryDao.findCategoryId(category);
    }


}
