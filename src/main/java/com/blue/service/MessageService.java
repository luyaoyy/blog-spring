package com.blue.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.pojo.Message;

/**
 * @author smily
 * @Description
 * @date 2023/5/20 15:26
 */
public interface MessageService {
    Page<Message> getMessageList(Page<Message> page);
    int sendMessage(Message message);
}
