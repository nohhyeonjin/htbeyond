package com.noh.htbeyond.service;

import com.noh.htbeyond.controller.dto.MembersResDTO;
import com.noh.htbeyond.model.Gender;
import com.noh.htbeyond.model.Member;
import com.noh.htbeyond.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(String name, String nickname, String encPassword, String phoneNumber, String email, Gender gender) {
        Member member = Member.builder()
                .name(name)
                .nickname(nickname)
                .password(encPassword)
                .phoneNumber(phoneNumber)
                .email(email)
                .gender(gender)
                .build();

        memberRepository.save(member);

        return member;
    }

    public Member findById(Long id) {
        Optional<Member> oMember = memberRepository.findById(id);
        if (oMember.isPresent()) {
            return oMember.get();
        } else {
            return null;
        }
    }

    public Page<MembersResDTO> findAll(Pageable pageable) {
        return memberRepository.findAllWithLastOrder(pageable);
    }
}
