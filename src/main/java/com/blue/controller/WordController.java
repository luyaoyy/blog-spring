package com.blue.controller;

import com.blue.myenum.RespBeanEnum;
import com.blue.pojo.Word;
import com.blue.service.WordService;
import com.blue.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/24 8:23
 */
@RequestMapping("/api")
@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/getWordList")
    public Response<List<Word>> getWordList(){
        return Response.success(RespBeanEnum.SUCCESS.getMessage(),wordService.getWordList());
    }
}
