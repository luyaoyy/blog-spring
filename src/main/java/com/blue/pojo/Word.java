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

import java.util.Date;

/**
 * @author smily
 * @Description 聊天消息实体类
 * @date 2023/5/23 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @TableId(value = "word_id", type = IdType.AUTO)
    private Integer wordId;
    private Integer userId;
    @TableField(exist = false)//排除在表中查询改字段,防止出现未知字段的错误
    private UserInfoDto userInfo;
    private String content;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date wordCreateTime;
}
