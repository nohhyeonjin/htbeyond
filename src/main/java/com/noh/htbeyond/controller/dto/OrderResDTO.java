package com.noh.htbeyond.controller.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResDTO {
    private Long orderNum;

    private String productName;

    private LocalDateTime paymentTime;

    public OrderResDTO(Long orderNum, String productName, LocalDateTime paymentTime) {
        this.orderNum = orderNum;
        this.productName = productName;
        this.paymentTime = paymentTime;
    }

}
