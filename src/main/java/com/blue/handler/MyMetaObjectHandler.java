package com.blue.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("messageCreateTime", new Date(), metaObject);
        this.setFieldValByName("wordCreateTime", new Date(), metaObject);
        this.setFieldValByName("gender", 0, metaObject);
        this.setFieldValByName("userStatus", 0, metaObject);
        this.setFieldValByName("avatar", "/images/default-avatar.png", metaObject);
        this.setFieldValByName("background", "/images/default-background.png", metaObject);
        this.setFieldValByName("motto", "再看一眼就会爆炸，再靠近一点就会融化~~~", metaObject);
        this.setFieldValByName("userRank", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
