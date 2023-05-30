package com.blue.controller;

import com.blue.exception.GlobalException;
import com.blue.myenum.RespBeanEnum;
import com.blue.utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    private final static long MAX_SIZE = 35 * 1024 * 1024;

    @PostMapping("/uploadImg")
    public Response<?> fileUpload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + hzName;
        String photoPath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + fileName;
//        String photoPath = "/www/wwwroot/blog/blog-spring/images/" + fileName;
        file.transferTo(new File(photoPath));
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), "/images/" + fileName);
    }

    @PostMapping("/uploadMusic")
    public Response<?> musicUpload(MultipartFile file) throws IOException {
        String musicName = file.getOriginalFilename();
        long size = file.getSize();
        if (size > MAX_SIZE) throw new GlobalException(RespBeanEnum.MUSICSIZE_ERROR);
        String hzName = musicName.substring(musicName.lastIndexOf("."));
        if (hzName.equals(".flac") || hzName.equals(".mp3")) {
            musicName = UUID.randomUUID() + hzName;
            String photoPath = System.getProperty("user.dir") + "/src/main/resources/static/music/" + musicName;
//            String photoPath = "/www/wwwroot/blog/blog-spring/music/" + musicName;
            file.transferTo(new File(photoPath));
            return Response.success(RespBeanEnum.SUCCESS.getMessage(), "/music/" + musicName);
        }
        throw new GlobalException(RespBeanEnum.MUSICNAME_ERROR);
    }
}
