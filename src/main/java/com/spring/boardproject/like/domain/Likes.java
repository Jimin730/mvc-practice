package com.spring.boardproject.like.domain;

import com.spring.boardproject.board.domain.Board;
import com.spring.boardproject.member.domain.Member;
import jakarta.persistence.*;


@Entity
public class Likes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
}
