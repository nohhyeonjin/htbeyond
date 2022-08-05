package com.noh.htbeyond.controller.dto;

import com.noh.htbeyond.model.Gender;

public interface MembersResDTO {

    String getNickname();
    String getName();
    String getPhoneNumber();
    String getEmail();
    Gender getGender();
    String getOrderNumber();

}
