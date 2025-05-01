package com.spring.boardproject.board.domain;

import com.spring.boardproject.comment.domain.Comment;
import com.spring.boardproject.like.domain.Likes;
import com.spring.boardproject.member.domain.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;


}
