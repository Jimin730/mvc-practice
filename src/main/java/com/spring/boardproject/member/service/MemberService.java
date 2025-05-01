package com.spring.boardproject.member.service;

import com.spring.boardproject.member.domain.Member;
import com.spring.boardproject.member.dto.MemberDTO;
import com.spring.boardproject.member.dto.MemberRegisterResponseDTO;
import com.spring.boardproject.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberRegisterResponseDTO saveMember(MemberDTO memberDTO) {
        Member member = Member.builder()
                .loginId(memberDTO.getLoginId())
                .password(memberDTO.getPassword())
                .name(memberDTO.getName())
                .nickName(memberDTO.getNickName())
                .createdDate(LocalDateTime.now())
                .build();

        memberRepository.save(member); //db에 저장

        return MemberRegisterResponseDTO.builder()
                .nickName(member.getNickName())
                .build();
    }

    public boolean checkLoginDuplicate(String loginId) { //로그인 id 중복 체크
        return memberRepository.existsByLoginId(loginId);
    }

    public boolean checkNickNameDuplicate(String nickName) { //닉네임 중복 체크
        return memberRepository.existsByNickName(nickName);
    }
}
