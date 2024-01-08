package com.example.missionproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// 댓글
@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 작성자
    private String password; // 비밀번호
    private String content; // 댓글 내용

    // 여러 댓글은 하나의 게시글에 달림
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
