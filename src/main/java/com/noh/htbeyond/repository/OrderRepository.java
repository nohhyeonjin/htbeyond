package com.noh.htbeyond.repository;

import com.noh.htbeyond.model.Member;
import com.noh.htbeyond.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByMember(Member member);
}
