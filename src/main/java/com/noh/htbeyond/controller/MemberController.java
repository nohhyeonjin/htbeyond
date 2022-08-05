package com.noh.htbeyond.controller;

import com.noh.htbeyond.controller.dto.JoinDTO;
import com.noh.htbeyond.model.Member;
import com.noh.htbeyond.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/member")
    public Long Join(@RequestBody @Valid JoinDTO joinDTO) {
        String rawPassword = joinDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        Member member = memberService.join(joinDTO.getName(), joinDTO.getNickname(), encPassword, joinDTO.getPhoneNumber(), joinDTO.getEmail(), joinDTO.getGender());

        return member.getId();
    }

}
