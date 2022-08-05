package com.noh.htbeyond.repository;

import com.noh.htbeyond.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
