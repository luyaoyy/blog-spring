package com.blue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    @NotNull(message = "用户名不能为空!")
    private String username;
    @NotNull(message = "密码不能为空!")
    private String password;
}
