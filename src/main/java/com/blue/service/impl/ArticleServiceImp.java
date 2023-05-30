package com.blue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.mapper.ArticleMapper;

import com.blue.pojo.Article;
import com.blue.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.IIOParam;
import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/13 16:09
 */
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int add(Article blog) {
        return articleMapper.insert(blog);
    }

    @Override
    public Page<Article> getArticleList(Page<Article> page) {
        Page<Article> articles = articleMapper.getArticleList(page);
        return articles;
    }

    @Override
    public Article showArticleDetail(int id) {
        Article article = articleMapper.showArticleDetail(id);
        return article;
    }

    @Override
    public List<Article> getHotArticleList(List<Integer> idList) {
        return articleMapper.getHotArticleList(idList);
    }

    @Override
    public Article getRandomArticle() {
        return articleMapper.getRandomArticle();
    }

    @Override
    public List<Article> getRecommendArticle(String tag, Integer id) {
        return articleMapper.getRecommendArticle(tag, id);
    }

    @Override
    public List<Article> getArticleByType(String type) {
        return articleMapper.getArticleByType(type);
    }

    @Override
    public List<Article> getArticleByTag(String tag) {
        return articleMapper.getArticleByTag(tag);
    }

    @Override
    public long countArticleByType(String type) {
        return articleMapper.selectCount(new QueryWrapper<Article>().like("type", type));
    }

    @Override
    public long countArticleByTag(String tag) {
        return articleMapper.selectCount(new QueryWrapper<Article>().like("tag", tag));
    }

}
