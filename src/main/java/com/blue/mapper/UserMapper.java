package com.blue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blue.dto.UserInfoDto;
import com.blue.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author smily
 * @Description
 * @date 2023/5/17 11:02
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    UserInfoDto getInfoByName(String username);
    UserInfoDto getInfoById(Integer userId);
}
