package com.blue.utils;

import com.blue.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author smily
 * @Description
 * @date 2023/5/23 22:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WordBean {
    private boolean system;
    private UserInfoDto userInfo;
    private Object message;

    public static WordBean wordUtil(boolean system,UserInfoDto userInfo,Object message){
        return new WordBean(system,userInfo,message);
    }
}
