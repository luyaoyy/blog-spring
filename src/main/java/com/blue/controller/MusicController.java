package com.blue.controller;

import com.blue.exception.GlobalException;
import com.blue.myenum.RespBeanEnum;
import com.blue.pojo.Music;
import com.blue.service.MusicService;
import com.blue.utils.Response;
import org.apache.el.lang.ELArithmetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/21 10:02
 */
@RestController
@RequestMapping("/api")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/getMusicListById")//用户状态更新后根据用户获取音乐列表
    public Response<List<Music>> getMusicListById(Integer userId){
        List<Music> musicList=musicService.getMusicListById(userId);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(),musicList);
    }

    @GetMapping("/getSysMusicList")
    public Response<List<Music>> getSysMusic(){
        return Response.success(RespBeanEnum.SUCCESS.getMessage(),musicService.getSysMusic());
    }

    @GetMapping("/getMyMusicList")
    public Response<List<Music>> getMyMusicList(Integer userId){
        List<Music> musicList=musicService.getMyMusicList(userId);
        return Response.success(RespBeanEnum.SUCCESS.getMessage(),musicList);
    }

    @DeleteMapping("/delMyMusic")
    public Response<?> delMyMusic(Integer musicId){
        int row=musicService.delMyMusic(musicId);
        if (row>0) return Response.success(RespBeanEnum.DELETEMUSIC_SUCCESS.getMessage());
        else throw new GlobalException(RespBeanEnum.DELETEMUSIC_ERROR);
    }

    @PostMapping("/addMusic")
    public Response<?> addMusic(@Valid @RequestBody Music music){
        int row=musicService.addMusic(music);
        if (row>0) return Response.success(RespBeanEnum.ADDMUSIC_SUCCESS.getMessage());
        else throw new GlobalException(RespBeanEnum.MUSICADD_ERROR);
    }
}
