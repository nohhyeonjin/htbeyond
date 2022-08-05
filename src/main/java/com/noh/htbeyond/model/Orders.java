package com.noh.htbeyond.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Orders {

    @Id
    private Long orderNum;

    @Column(length = 100, nullable = false)
    private String productName;

    @Column(nullable = false)
    private LocalDateTime paymentTime;

}
