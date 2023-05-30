package com.blue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.pojo.Article;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/13 16:11
 */
public interface ArticleService {
    int add(Article blog);

    Page<Article> getArticleList(Page<Article> page);
    Article showArticleDetail(int id);

    List<Article> getHotArticleList(List<Integer> idList);

    Article getRandomArticle();

    List<Article> getRecommendArticle(String tag,Integer id);

    List<Article> getArticleByType(String type);

    List<Article> getArticleByTag(String tag);
    long countArticleByType(String type);

    long countArticleByTag(String tag);
}
