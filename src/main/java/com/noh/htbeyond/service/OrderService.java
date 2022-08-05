package com.noh.htbeyond.service;

import com.noh.htbeyond.model.Member;
import com.noh.htbeyond.model.Orders;
import com.noh.htbeyond.repository.MemberRepository;
import com.noh.htbeyond.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    public List<Orders> findById(Long id) {
        Optional<Member> oMember = memberRepository.findById(id);
        if (oMember.isEmpty()) {
            return null;
        } else {
            return orderRepository.findByMember(oMember.get());
        }
    }
}
