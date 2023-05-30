package com.blue.controller;

import com.blue.myenum.RespBeanEnum;
import com.blue.pojo.News;
import com.blue.service.NewsService;
import com.blue.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/27 15:38
 */
@RequestMapping("/api")
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/getNewsList")
    public Response<List<News>> getNewsList() {
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), newsService.getNewsList());
    }

    @GetMapping("/getDetailById")
    public Response<News> getDetailById(Integer newsId) {
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), newsService.getDetailById(newsId));
    }
}
