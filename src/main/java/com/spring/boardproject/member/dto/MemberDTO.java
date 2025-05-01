package com.spring.boardproject.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String loginId;
    private String password;
    private String name;
    private String nickName;

}
