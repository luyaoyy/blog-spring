package com.blue.controller;

import com.alibaba.fastjson.JSON;
import com.blue.dto.UserInfoDto;
import com.blue.dto.UserLoginDto;
import com.blue.exception.GlobalException;
import com.blue.myenum.RespBeanEnum;
import com.blue.pojo.User;
import com.blue.service.UserService;
import com.blue.utils.MD5Util;
import com.blue.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author smily
 * @Description
 * @date 2023/5/17 11:05
 */
@RequestMapping("/api")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/checkUserName")
    public Response<?> checkUserName(String username) {
        User user = userService.getUserByUserName(username);
        System.out.println(user);
        if (user != null) throw new GlobalException(RespBeanEnum.REPEAT_ERROR);
        return Response.success(RespBeanEnum.SUCCESS.getMessage());
    }

    @PostMapping("/userRegister")
    public Response<?> userRegister(@Valid @RequestBody User user) {
        int row = userService.userRegister(user);
        if (row > 0) return Response.success(RespBeanEnum.REGISTER_SUCCESS.getMessage());
        throw new GlobalException(RespBeanEnum.ERROR);
    }

    @PostMapping("/userLogin")
    public Response<?> userLogin(@Valid @RequestBody UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        User user = userService.getUserByUserName(username);
        System.out.println(user);
        if (user == null) throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        String inputPassword = MD5Util.secondMd5(password, user.getSalt());
        if (inputPassword.equals(user.getPassword())) {
            UserInfoDto userInfoDto = userService.getInfoById(user.getUserId());//向前端返回排除密码的用户信息，而不是完整的用户信息
            return Response.success(RespBeanEnum.LOGIN_SUCCESS.getMessage(), userInfoDto);
        } else {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
    }

    @GetMapping("/getInfoById")
    public Response<UserInfoDto> getInfoById(Integer userId) {
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), userService.getInfoById(userId));
    }

    @GetMapping("/getAllInfoById")
    public Response<User> getAllInfoById(Integer userId) {
        return Response.success(RespBeanEnum.SUCCESS.getMessage(), userService.getAllInfoById(userId));
    }

    @PostMapping("/updateInfo")
    public Response<UserInfoDto> updateInfo(@RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile, @RequestParam(value = "backgroundFile", required = false) MultipartFile backgroundFile, @RequestParam("user") String userJson) throws IOException {
        String avatarPath;
        String backgroundPath;
        User user = JSON.parseObject(userJson, User.class);
        User check=userService.updateCheck(user.getUsername(),user.getUserId());
        if (check!=null) throw new GlobalException(RespBeanEnum.REPEAT_ERROR);
        if (avatarFile != null) {
            String fileName = avatarFile.getOriginalFilename();
            String hzName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID() + hzName;
            String photoPath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + fileName;
//        String photoPath = "/www/wwwroot/blog/blog-spring/images/" + fileName;
            avatarFile.transferTo(new File(photoPath));
            avatarPath = "/images/" + fileName;
            user.setAvatar(avatarPath);
        }
        if (backgroundFile != null) {
            String fileName = backgroundFile.getOriginalFilename();
            String hzName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID() + hzName;
            String photoPath = System.getProperty("user.dir") + "/src/main/resources/static/images/" + fileName;
//        String photoPath = "/www/wwwroot/blog/blog-spring/images/" + fileName;
            backgroundFile.transferTo(new File(photoPath));
            backgroundPath = "/images/" + fileName;
            user.setBackground(backgroundPath);
        }
        userService.updateInfo(user);
        UserInfoDto newUser=userService.getInfoById(user.getUserId());
        return Response.success(RespBeanEnum.UPDATEUSERINFO_SUCCESS.getMessage(),newUser);
    }
}
