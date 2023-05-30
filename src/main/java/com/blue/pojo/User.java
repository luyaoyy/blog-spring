package com.blue.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @author smily
 * @Description 用户实体类
 * @date 2023/5/17 10:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @Length(min = 4, max = 10, message = "用户名长度应为6~10")
    @NotNull(message = "用户名不能为空!")
    private String username;

    @Length(min = 4, max = 12, message = "密码长度应为6~10")
    @NotNull(message = "密码不能为空!")
    @JsonProperty(value = "password")
    private String password;

    private String salt;

    @TableField(fill = FieldFill.INSERT)
    private Integer gender;

    @TableField(fill = FieldFill.INSERT)
    private String motto;

    private String career;

    @TableField(fill = FieldFill.INSERT)
    private String avatar;

    @TableField(fill = FieldFill.INSERT)
    private String background;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT)
    private Integer userStatus;

    @TableField(fill = FieldFill.INSERT)
    private Integer userRank;
}
