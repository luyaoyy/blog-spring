package com.blue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blue.mapper.NewsMapper;
import com.blue.pojo.News;
import com.blue.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/27 15:37
 */
@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getNewsList() {
        return newsMapper.selectList(new QueryWrapper<News>().last("limit 6"));
    }

    @Override
    public News getDetailById(Integer newsId) {
        return newsMapper.selectOne(new QueryWrapper<News>().eq("news_id",newsId));
    }
}
