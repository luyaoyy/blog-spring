package com.blue.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.mapper.MessageMapper;
import com.blue.pojo.Message;
import com.blue.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smily
 * @Description
 * @date 2023/5/20 15:26
 */
@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Page<Message> getMessageList(Page<Message> page) {
        return messageMapper.getMessageList(page);
    }

    @Override
    public int sendMessage(Message message) {
        return messageMapper.insert(message);
    }
}
