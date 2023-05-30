package com.blue.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author smily
 * @Description
 * @date 2023/5/21 9:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @TableId(value = "music_id", type = IdType.AUTO)
    private Integer musicId;
    private Integer userId;

    @TableField(exist = false)//标明该字段表结构中没有,防止出现未知字段的错误
    private User user;

    @NotBlank(message = "歌曲名不能为空!")
    @NotNull(message = "歌曲名不能为空!")
    @Length(max = 15, message = "歌曲名长度最大15!")
    private String title;

    @NotBlank(message = "歌手名不能为空!")
    @NotNull(message = "歌手名不能为空!")
    @Length(max = 15, message = "歌手名长度最大10!")
    private String artist;
    private String url;
    @NotBlank(message = "封面不能为空!")
    @NotNull(message = "封面不能为空!")
    private String pic;
    private Integer isSys;
}
