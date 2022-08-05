package com.noh.htbeyond.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
public class Orders {

    @Id
    private Long orderNum;

    @Column(length = 100, nullable = false)
    private String productName;

    @Column(nullable = false)
    private LocalDateTime paymentTime;

    @ManyToOne
    private Member member;

}
