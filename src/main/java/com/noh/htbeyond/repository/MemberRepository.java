package com.noh.htbeyond.repository;

import com.noh.htbeyond.controller.dto.MembersResDTO;
import com.noh.htbeyond.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    @Query(value = "select nickname, name, phone_number as phoneNumber, email, gender, order_num as orderNumber " +
            "from member left join orders on member.id = orders.member_id " +
            "where member.last_order_time = orders.payment_time or member.last_order_time is null", nativeQuery = true)
    Page<MembersResDTO> findAllWithLastOrder(Pageable pageable);

}
