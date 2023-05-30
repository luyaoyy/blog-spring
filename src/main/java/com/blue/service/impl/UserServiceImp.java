package com.blue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blue.dto.UserInfoDto;
import com.blue.mapper.UserMapper;
import com.blue.pojo.User;
import com.blue.service.UserService;
import com.blue.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author smily
 * @Description
 * @date 2023/5/17 11:06
 */

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int userRegister(User user) {
        String salt = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
        String password = user.getPassword();
        user.setPassword(MD5Util.secondMd5(password, salt));
        user.setSalt(salt);
        int row = userMapper.insert(user);
        return row;
    }

    @Override
    public User getUserByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public UserInfoDto getInfoByName(String username) {
        return userMapper.getInfoByName(username);
    }

    @Override
    public UserInfoDto getInfoById(Integer userId) {
        return userMapper.getInfoById(userId);
    }

    @Override
    public User getAllInfoById(Integer userId) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
    }

    @Override
    public int updateInfo(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User updateCheck(String username, Integer userId) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username).ne("user_id",userId);
        return userMapper.selectOne(queryWrapper);
    }
}
