package com.noh.htbeyond.controller.dto;

import com.noh.htbeyond.model.Gender;
import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class JoinDTO {

    @Pattern(regexp = "^[ㄱ-ㅎㅣ가-힣|a-z|A-Z]+$")
    @NotEmpty
    private String name;

    @Pattern(regexp = "^[a-z]+$")
    @NotEmpty
    private String nickname;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{10,20}$")
    @NotEmpty
    private String password;

    @Pattern(regexp = "^[0-9]+$")
    @NotEmpty
    private String phoneNumber;

    @Email
    @NotEmpty
    private String email;

    private Gender gender;
}
