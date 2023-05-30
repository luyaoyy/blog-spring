package com.blue.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.blue.dto.UserInfoDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author smily
 * @Description 博客类
 * @date 2023/5/13 15:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private UserInfoDto userInfoDto;

    @NotNull(message = "博客标题不能为空!")
    @NotBlank(message = "博客标题不能为空!")
    @Length(min = 4, max = 100,message = "博客标题长度应为4~100")
    private String title;

    @NotNull(message = "博客描述不能为空!")
    @NotBlank(message = "博客描述不能为空!")
    @Length(min = 4,message = "博客描述长度最少应为4")
    private String blogDescribe;

    @NotNull(message = "博客内容不能为空!")
    @NotBlank(message = "博客内容不能为空!")
    @Length(min = 20,message = "博客内容太短，请重新编辑!")
    private String htmlContent;

    @NotNull(message = "博客内容不能为空!")
    @NotBlank(message = "博客内容不能为空!")
    @Length(min = 20,message = "博客内容太短，请重新编辑!")
    private String mdContent;

    @NotNull(message = "请选择博客标签!")
    @NotBlank(message = "请选择博客标签!")
    private String tag;

    @NotNull(message = "请选择博客类型!")
    private String type;

    @NotNull(message = "请选择博客封面!")
    @NotBlank(message = "请选择博客封面!")
    private String cover;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}
