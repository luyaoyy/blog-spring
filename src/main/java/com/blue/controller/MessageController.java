package com.blue.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.exception.GlobalException;
import com.blue.myenum.RespBeanEnum;
import com.blue.pojo.Message;
import com.blue.service.MessageService;
import com.blue.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author smily
 * @Description
 * @date 2023/5/20 15:27
 */
@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/getMessageList")
    public Response<Page<Message>> getMessageList(int current){
        Page<Message> page=new Page<>(current,4);
        Page<Message> pageInfo=messageService.getMessageList(page);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(),pageInfo);
    }

    @PostMapping("/sendMessage")
    public Response<?> sendMessage(@Valid @RequestBody Message message){
        int row=messageService.sendMessage(message);
        if (row>0) return Response.success(RespBeanEnum.SENDMESSAGE_SUCCESS.getMessage());
        else throw new GlobalException(RespBeanEnum.ERROR);
    }
}
