package com.blue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blue.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author smily
 * @Description
 * @date 2023/5/27 15:37
 */
@Mapper
@Repository
public interface NewsMapper extends BaseMapper<News> {
}
