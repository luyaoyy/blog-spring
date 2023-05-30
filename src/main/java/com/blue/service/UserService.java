package com.blue.service;

import com.blue.dto.UserInfoDto;
import com.blue.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author smily
 * @Description
 * @date 2023/5/17 11:05
 */
public interface UserService {

    int userRegister(User user);

    User getUserByUserName(String username);

    UserInfoDto getInfoByName(String username);

    UserInfoDto getInfoById(Integer userId);

    User getAllInfoById(Integer userId);

    int updateInfo(User user);

    User updateCheck(@Param("username") String username, @Param("userId") Integer userId);
}
