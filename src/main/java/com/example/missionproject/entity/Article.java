package com.example.missionproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// 게시글
@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String author; // 게시글 작성자
    private String password; // 비밀번호

    // 여러 게시글이 하나의 게시판 주제를 가짐
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    // 하나의 게시글은 여러 댓글을 가짐
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    // 해시태그와 게시글 다대 다 관계
    @OneToMany(mappedBy = "article")
    private List<ArticleHashtag> articleHashtags = new ArrayList<>();
}
