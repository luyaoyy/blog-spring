package com.blue.service;

import com.blue.pojo.News;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/27 15:37
 */
public interface NewsService {
    List<News> getNewsList();

    News getDetailById(Integer newsId);
}
