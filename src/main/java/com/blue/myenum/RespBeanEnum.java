package com.blue.myenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum RespBeanEnum {

    SUCCESS(200, "请求成功!"),
    LOGIN_SUCCESS(200, "登入成功!"),
    REGISTER_SUCCESS(200, "恭喜你，注册成功!"),
    PUBLISH_SUCCESS(200, "恭喜你，博客发布成功!"),

    SENDMESSAGE_SUCCESS(200, "留言成功!"),
    DELETEMUSIC_SUCCESS(200, "删除音乐成功!"),
    ADDMUSIC_SUCCESS(200, "添加音乐成功!"),
    UPDATEUSERINFO_SUCCESS(200, "资料更新成功!"),
    ERROR(500, "服务器故障!请联系系统管理员!"),
    REPEAT_ERROR(50000, "用户名重复!"),
    LOGIN_ERROR(50001, "用户名或密码错误!"),
    DELETEMUSIC_ERROR(50002, "删除失败，请稍后重试!"),
    MUSICNAME_ERROR(50003, "文件类型不符!"),
    MUSICSIZE_ERROR(50004, "文件最多为35MB!"),
    MUSICADD_ERROR(50005, "添加音乐失败,请稍后重试!");
    //code在前，message在后，函数，属性顺序不能变
    private final Integer code;
    private final String message;

}
