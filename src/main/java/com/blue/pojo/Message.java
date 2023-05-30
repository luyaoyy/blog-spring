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
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author smily
 * @Description 留言实体类
 * @date 2023/5/20 15:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @TableId(value = "message_id", type = IdType.AUTO)
    private Integer messageId;

    private Integer userId;
    private UserInfoDto userInfoDto;

    @NotNull(message = "留言不能为空!")
    @NotBlank(message = "留言不能为空!")
    @Length(max = 250,message = "留言最长不超过250!")
    private String messageContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date messageCreateTime;
}
