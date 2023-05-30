package com.blue;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.mapper.ArticleMapper;
import com.blue.pojo.Article;
import com.blue.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BlogSpringApplicationTests {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void t() {
        String pattern="article:type:*";
        Set<String> keys = redisTemplate.keys(pattern);
        for (String key:keys){
            System.out.println(key);
            System.out.println(redisTemplate.opsForList().range(key,0,-1));
        }
    }

    @Test
    void zSet() {
        String setName = "test:rank";
//        redisTemplate.opsForZSet().add(setName, "tom", 100);//向指定集合中加名为tom的元素，如果元素名存在则返回false，不存在返回true
//        redisTemplate.opsForZSet().add(setName, "pick", 150);
//        redisTemplate.opsForZSet().add(setName, "xiaohong", 666);
//        redisTemplate.opsForZSet().add(setName, "smily", 12);
//        redisTemplate.opsForZSet().add(setName, "luyys", 888);
//        redisTemplate.opsForZSet().add(setName, "big", 700);
//        redisTemplate.opsForZSet().add(setName, "ljq", 999);
//        System.out.println(redisTemplate.opsForZSet().popMin(setName));//移除集合中score最小的元素，返回该元素对应的score和名字
//        System.out.println(redisTemplate.opsForZSet().zCard(setName));//返回集合中元素个数
//        System.out.println(redisTemplate.opsForZSet().count(setName,10,1000));//返回指定集合名中的元素score在10到1000的元素个数
//        System.out.println(redisTemplate.opsForZSet().range(setName,0,1));//返回集合中默认从小到大顺序排序后下标为0到1的元素个数
//        System.out.println(redisTemplate.opsForZSet().remove(setName,"pick"));//移除指定集合名中的元素名为pick的元素，返回成功返回1，失败返回1
//        System.out.println(redisTemplate.opsForZSet().score(setName,"tom"));//返回集合中元素名为tom的score，类型为double
//        System.out.println(redisTemplate.opsForZSet().rangeByScore(setName,150,600));//返回集合中元素score在150到600之间的元素集合
//        System.out.println(redisTemplate.opsForZSet().incrementScore(setName,"ljq1",100));//为集合中名为ljq的元素score值加100，返回增加后的值，如果元素不存在，则会自动添加该元素并默认score为0再加100
//        System.out.println(redisTemplate.opsForZSet().rank(setName,"smily"));//返回集合中元素名为smily在集合中从小到大排序中的下标，下标从0开始
//        System.out.println(redisTemplate.opsForZSet().reverseRank(setName,"ljq"));//返回集合中元素名为smily在集合中从大到小排序中的下标，下标从0开始
    }

    @Test
    void list() {
//        String listName = "list:l1";
//        System.out.println(redisTemplate.opsForList().leftPush(listName, "admin"));//向list左边添加一个元素，返回添加后list长度，如果该list不存在则创建改list并添加
//        System.out.println(redisTemplate.opsForList().leftPushAll(listName, list));//向list左边添加一个集合，返回添加后list长度
//        System.out.println(redisTemplate.opsForList().leftPushIfPresent(listName,100));//向list左边添加一个元素，返回添加后的list长度，如果该list不存在则不添加
//        System.out.println(redisTemplate.opsForList().leftPop(listName));//将list最左边的元素移除，同时返回移除的元素
//        System.out.println(redisTemplate.opsForList().range(listName, 0, 0)); // 获取下标0~0的
//        redisTemplate.opsForList().range(listName, 0, 1); // 获取下标0~1的元素
//        redisTemplate.opsForList().range(listName, 0, -1); // 获取所有的元素
//        System.out.println(redisTemplate.opsForList().index(listName,0));//获取下标为0的元素，下标从最左边开始记为0，如果下标为-1则返回最后一个,越界则返回null
//        System.out.println(redisTemplate.opsForList().remove(listName, 0, "admin"));//移除list中admin的元素，第二个参数可选-1 0 1，表示移除最左边的admin,移除全部admin,移除最右边的admin
//        List<String> list = new ArrayList<>();
//        String listName= "article:type:生活分享";
//        list.add("情感");
//        list.add("旅游");
//        list.add("成长");
//        list.add("治愈");
//        list.add("运动");
//        list.add("相遇");
//        list.add("朋友");
//        list.add("家人");
//        for (String t:list) redisTemplate.opsForList().rightPush(listName,t);
    }

    @Test
    void hash(){
        String hashName="hash:h1";
        redisTemplate.opsForHash().put(hashName,"b",2);
    }

}
