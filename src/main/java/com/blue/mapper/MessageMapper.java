package com.blue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author smily
 * @Description
 * @date 2023/5/20 15:25
 */
@Mapper
@Repository
public interface MessageMapper extends BaseMapper<Message> {
    Page<Message> getMessageList(Page<Message> page);
}
