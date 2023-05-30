package com.blue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blue.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author smily
 * @Description
 * @date 2023/5/21 9:59
 */
@Mapper
@Repository
public interface MusicMapper extends BaseMapper<Music> {
}
