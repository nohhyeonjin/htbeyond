package com.noh.htbeyond.controller.dto;

import com.noh.htbeyond.model.Gender;
import lombok.Getter;

@Getter
public class MemberResDTO {
    private String email;
    private String name;
    private String nickname;
    private String phoneNumber;
    private Gender gender;

    public MemberResDTO(String email, String nickname, String name, String phoneNumber, Gender gender) {
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

}
