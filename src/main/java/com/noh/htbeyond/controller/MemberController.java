package com.noh.htbeyond.controller;

import com.noh.htbeyond.controller.dto.JoinDTO;
import com.noh.htbeyond.controller.dto.MemberResDTO;
import com.noh.htbeyond.controller.dto.MembersResDTO;
import com.noh.htbeyond.model.Member;
import com.noh.htbeyond.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/member")
    @ApiOperation(value = "회원가입", tags = "member")
    public Long Join(@RequestBody @Valid JoinDTO joinDTO) {
        String rawPassword = joinDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        Member member = memberService.join(joinDTO.getName(), joinDTO.getNickname(), encPassword, joinDTO.getPhoneNumber(), joinDTO.getEmail(), joinDTO.getGender());

        return member.getId();
    }

    @GetMapping("/member/{id}")
    @ApiOperation(value = "단일 회원 상세 정보 조회", tags = "member")
    public MemberResDTO getMember(@PathVariable Long id) {
        Member member = memberService.findById(id);

        return new MemberResDTO(member.getEmail(), member.getNickname(), member.getName(), member.getPhoneNumber(), member.getGender());
    }

    @GetMapping("/members")
    @ApiOperation(value = "여러 회원 목록 조회", tags = "member")
    public List<MembersResDTO> getMembers(Pageable pageable) {
        return memberService.findAll(pageable).getContent();
    }

}
