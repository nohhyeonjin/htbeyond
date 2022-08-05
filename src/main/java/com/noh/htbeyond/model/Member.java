package com.noh.htbeyond.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String email;

    private Boolean gender;

}
