package com.spring.boardproject.member.controller;

import com.spring.boardproject.member.dto.MemberDTO;
import com.spring.boardproject.member.dto.MemberRegisterResponseDTO;
import com.spring.boardproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


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
    public ModelAndView signup(ModelAndView modelAndView, WebRequest request) {

        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String nickName = request.getParameter("nickName");

        MemberDTO memberDTO = new MemberDTO(loginId, password, name, nickName);

        MemberRegisterResponseDTO member = memberService.saveMember(memberDTO);

        modelAndView.addObject("nickname", member.getNickName());
        modelAndView.setViewName("main/main");

        return modelAndView;
    }


}
