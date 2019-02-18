package com.example.news.controller;

import com.example.news.converter.NewsConverter;
import com.example.news.domain.Category;
import com.example.news.domain.News;
import com.example.news.domain.NewsParam;
import com.example.news.domain.QueryNewsPageResponse;
import com.example.news.mysql.PagedResult;
import com.example.news.service.CategoryService;
import com.example.news.service.NewsService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authou YXY
 * @Date 2018/11/14 23:05
 */
@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/getById")
    public News getById(Integer id){
        News news = newsService.getById(id);

//        News news = new News();
//        news.setCategoryId("1");
//        news.setContent("新闻一");
//        news.setTitle("标题一");
//        news.setId(1);
        return news;
    }

    /**
     * 根据分类名称获取对应新闻
     *
     * @param category
     * @return
     */
    @GetMapping(value = "/find")
    public List<News> findNewsByCategoryId(String category) {
        System.out.println("============findNewsByCategoryIdController");

        Category category1 = categoryService.findCategoryId(category);
        Integer cate = category1.getId();
        List<News> list = newsService.findNewsByCategoryId(cate);
        int listCount = list.size();
        List newsList = new ArrayList();
        for (int i = 0; i < listCount; i++) {
            String title = list.get(i).getTitle();
            String content = list.get(i).getContent();
            newsList.add(title);
            newsList.add(content);
        }


        return newsList;
    }


    @GetMapping(value = "/findAllNews")
    public List<News> queryAllNewsByCategoryId(@RequestParam("categoryId") Integer categoryId) {
        System.out.println("============queryNewsByCategoryIdController" + categoryId);
        return newsService.findNewsByCategoryId(categoryId);
    }

    /**
     * 根据分类ID获取新闻内容，并分页
     *
     * @param param
     * @return
     */
    @GetMapping(value = "/findNews")
    public QueryNewsPageResponse<News> queryNewsByCategoryId(NewsParam param) {
        System.out.println("============queryNewsByCategoryIdController");
        PagedResult<News> list = newsService.queryNewsByPage(param);

//        PagedResult<News> list = initData();

        return NewsConverter.toQueryNewsPageResponse(list);
    }

    @GetMapping(value = "/findAll")
    public QueryNewsPageResponse<News> findAll(NewsParam param) {
        System.out.println("============findAll");
        PagedResult<News> list = newsService.queryAllByPage(param);

//        PagedResult<News> list = initData();

        return NewsConverter.toQueryNewsPageResponse(list);
    }

    /**
     * 添加新闻
     *
     * @param news
     * @return
     */

    @PostMapping(value = "/add")
    public String addNews(@RequestBody News news) {
        System.out.println(">>>>>>>addController");
        int result = newsService.addNews(news);
        if (result > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }

    }

    /**
     * 删除新闻
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/del")
    public String delNews(int id) {
        int result = newsService.delNews(id);
        if (result > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }


    /**
     * 更新新闻
     *
     * @param news
     * @return
     */
    @PostMapping(value = "/upd")
    public String updNews(News news) {
        System.out.println(">>>>>>>>>>>>updController");
        int result = newsService.updNews(news);
        if (result > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

    private PagedResult<News> initData() {
        PagedResult<News> pages = new PagedResult<>();
        News news1 = new News();
        news1.setCategoryId("1");
        news1.setContent("新闻一");
        news1.setTitle("标题一");
        news1.setId(1);
        News news2 = new News();
        news2.setCategoryId("1");
        news2.setContent("新闻二");
        news2.setTitle("标题二");
        news2.setId(2);

        News news3 = new News();
        news3.setCategoryId("2");
        news3.setContent("新闻三");
        news3.setTitle("标题三");
        news3.setId(3);
        News news4 = new News();
        news4.setCategoryId("2");
        news4.setContent("新闻四");
        news4.setTitle("标题四");
        news4.setId(4);

        List<News> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);
        list.add(news3);
        list.add(news4);
        pages.setData(list);
        pages.setTotalCount(50);
        pages.setTotalPages(2);
        return pages;
    }
}
