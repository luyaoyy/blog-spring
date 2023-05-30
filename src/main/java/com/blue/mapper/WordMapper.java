package com.blue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blue.pojo.Word;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/24 8:23
 */
@Mapper
@Repository
public interface WordMapper extends BaseMapper<Word> {
    List<Word> getWordList();
}
