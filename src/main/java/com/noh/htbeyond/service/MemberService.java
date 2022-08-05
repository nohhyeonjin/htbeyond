package com.noh.htbeyond.service;

import com.noh.htbeyond.model.Gender;
import com.noh.htbeyond.model.Member;
import com.noh.htbeyond.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
