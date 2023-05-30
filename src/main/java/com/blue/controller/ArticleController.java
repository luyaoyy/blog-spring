package com.blue.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.exception.GlobalException;
import com.blue.myenum.RespBeanEnum;
import com.blue.pojo.Article;
import com.blue.service.ArticleService;
import com.blue.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @author smily
 * @Description
 * @date 2023/5/13 16:12
 */
@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/getTypesAndTags")
    public Response<?> getTypesAndTags() {
        String pattern = "article:type:*";
        Set<String> types = redisTemplate.keys(pattern);
        List<Map<String, List<String>>> typesAndTags = new ArrayList<>();
        assert types != null;
        for (String key : types) {
            List<Object> tags = redisTemplate.opsForList().range(key, 0, -1);
            List<String> list = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            assert tags != null;
            for (Object tag : tags) list.add((String) tag);
            map.put(key.substring(key.lastIndexOf(":") + 1), list);
            typesAndTags.add(map);
        }
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), typesAndTags);
    }

    @PostMapping("/publishBlog")
    public Response<Article> add(@Valid @RequestBody Article blog) {
        int n = articleService.add(blog);
        if (n > 0) return Response.success(RespBeanEnum.PUBLISH_SUCCESS.getMessage());
        else throw new GlobalException(RespBeanEnum.ERROR);
    }

    @GetMapping("/getTypes")
    public Response<List<String>> getTypes() {//获得文章类型及类型对应的文章数量
        String pattern = "article:type:*";
        Set<String> keys = redisTemplate.keys(pattern);
        List<String> res = new ArrayList<>();
        for (String key : keys) {
            Map<String, Long> typeAndCount = new HashMap<>();
            String type = key.substring(key.lastIndexOf(":") + 1);
            Long count = articleService.countArticleByType(type);
            String json = "{\"type\":\"" + type + "\"," + "\"count\":" + count + "}";
            res.add(json);
        }
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), res);
    }

    @GetMapping("/getArticleByType")
    public Response<List<Article>> getArticleByType(String type) {
        List<Article> articles = articleService.getArticleByType(type);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), articles);
    }

    @GetMapping("/getTags")
    public Response<List<String>> getTags() {//获得文章类型及类型对应的文章数量
        String pattern = "article:type:*";
        Set<String> keys = redisTemplate.keys(pattern);
        ArrayList<String> tagsAndCount = new ArrayList<>();
        for (String key : keys) {
            List<Object> tags = redisTemplate.opsForList().range(key, 0, -1);
            for (Object tag : tags) {
                long count = articleService.countArticleByTag((String) tag);
                if (count == 0) continue;
                String json = "{\"tag\":\"" + tag + "\"," + "\"count\":" + count + "}";
                tagsAndCount.add(json);
            }
        }
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), tagsAndCount);
    }

    @GetMapping("/getArticleByTag")
    public Response<List<Article>> getArticleByTag(String tag) {
        List<Article> articles = articleService.getArticleByTag(tag);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), articles);
    }

    @GetMapping("/getArticleList")
    public Response<Page<Article>> getArticle(Integer current) {
        Page<Article> page = new Page<>(current, 9);
        Page<Article> pageInfo = articleService.getArticleList(page);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), pageInfo);
    }

    @GetMapping("/showArticleDetail")
    public Response<Map<String, Object>> showArticleDetail(Integer id) {
        Map<String, Object> map = new HashMap<>();
        Article article = articleService.showArticleDetail(id);
        String setName = "article:count";
        double count = redisTemplate.opsForZSet().incrementScore(setName, id, 1);
        map.put("count", count);
        map.put("article", article);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), map);
    }

    @GetMapping("/getHotArticleList")
    public Response<List<Article>> getHotArticleList() {
        String setName = "article:count";
        Set<Object> idSet = redisTemplate.opsForZSet().reverseRange(setName, 0, 4);
        List<Integer> idList = new ArrayList<>();
        if (idSet != null) for (Object id : idSet) idList.add(Integer.parseInt(id.toString()));
        List<Article> articles = articleService.getHotArticleList(idList);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), articles);
    }

    @GetMapping("/getRandomArticle")
    public Response<Article> getRandomArticle() {
        Article article = articleService.getRandomArticle();
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), article);
    }

    @GetMapping("/getRecommendArticle")
    public Response<List<Article>> getRecommendArticle(String tag, Integer id) {
        List<Article> articleList = articleService.getRecommendArticle(tag, id);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), articleList);
    }

    @GetMapping("/countArticleByType")
    public Long countArticleByType(String type) {
        return articleService.countArticleByType(type);
    }

}
