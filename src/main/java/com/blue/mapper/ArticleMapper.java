package com.blue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author smily
 * @Description
 * @date 2023/5/13 16:05
 */
@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    Page<Article> getArticleList(Page<Article> page);

    Article showArticleDetail(int id);

    List<Article> getHotArticleList(List<Integer> idList);

    Article getRandomArticle();

    List<Article> getRecommendArticle(@Param("tag") String tag,@Param("id") Integer id);
    List<Article> getArticleByType(String type);
    List<Article> getArticleByTag(String tag);

}
