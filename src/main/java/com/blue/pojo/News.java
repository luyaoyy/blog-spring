package com.blue.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author smily
 * @Description 系统公告类
 * @date 2023/5/27 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @TableId(value = "news_id",type = IdType.AUTO)
    private Integer newsId;
    private String title;
    private String content;
    private String cover;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
