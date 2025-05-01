package com.spring.boardproject.member.controller;

import com.spring.boardproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, Boolean>> checkLoginId(@RequestBody Map<String, String> request) {

        String loginId = request.get("loginId");
        boolean isDuplicate = memberService.checkLoginDuplicate(loginId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);

        return ResponseEntity.ok(response);
    }

    //닉네임 중복 확인
    @PostMapping("/checkNickName")
    public ResponseEntity<Map<String, Boolean>> checkNickName(@RequestBody Map<String, String> request) {

        String nickName = request.get("nickName");
        boolean isDuplicate = memberService.checkNickNameDuplicate(nickName);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);

        return ResponseEntity.ok(response);
    }
}
