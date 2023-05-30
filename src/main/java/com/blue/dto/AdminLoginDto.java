package com.blue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginDto {
    @NotNull
    private String name;
    @NotNull
    private String password;
}
