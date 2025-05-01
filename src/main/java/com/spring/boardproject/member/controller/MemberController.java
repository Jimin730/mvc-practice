package com.spring.boardproject.member.controller;

import com.spring.boardproject.member.dto.MemberDTO;
import com.spring.boardproject.member.dto.MemberRegisterResponseDTO;
import com.spring.boardproject.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/member/*")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("signup")
    public void goSignup(){
    }

    @PostMapping("signup")
    public String signup(@Valid @RequestBody MemberDTO memberDTO, RedirectAttributes rttr) {

        try {
            MemberRegisterResponseDTO member = memberService.saveMember(memberDTO);

            rttr.addFlashAttribute("nickName", member.getNickName());

            return "redirect:/main"; // 회원가입 성공 시 메인으로 리다이렉트

        } catch (Exception e) {
            e.printStackTrace(); // 콘솔에 에러로그 출력

            rttr.addFlashAttribute("errorMessage", "회원가입 중 오류가 발생했습니다." + e.getMessage());

            return "redirect:/member/signup"; // 회원가입 실패 시 다시 회원가입 페이지로 리다이렉트
        }
    }


}
