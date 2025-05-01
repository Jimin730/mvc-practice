package com.spring.boardproject.member.controller;

import com.spring.boardproject.member.dto.CheckResponseDTO;
import com.spring.boardproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/member/*")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    //로그인 ID 중복 확인
    @PostMapping("/checkLoginId")
    public ResponseEntity<CheckResponseDTO> checkLoginId(@RequestParam String loginId) {

        boolean isDuplicate = memberService.checkLoginDuplicate(loginId);

        CheckResponseDTO responseDTO = new CheckResponseDTO(isDuplicate);

        return ResponseEntity.ok(responseDTO);
    }

    //닉네임 중복 확인
    @PostMapping("/checkNickName")
    public ResponseEntity<CheckResponseDTO> checkNickName(@RequestParam String nickName) {

        boolean isDuplicate = memberService.checkNickNameDuplicate(nickName);

        CheckResponseDTO responseDTO = new CheckResponseDTO(isDuplicate);

        return ResponseEntity.ok(responseDTO);
    }
}
