package com.blue.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author smily
 * @Description 前端展示用户信息
 * @date 2023/5/17 20:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private Integer userId;
    private String username;
    private Integer gender;
    private String motto;
    private String career;
    private String avatar;
    private String background;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    private Integer userStatus;

    private Integer userRank;
}
