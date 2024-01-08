package com.example.missionproject.Board.entity;

import com.example.missionproject.Board.entity.Board;
import jakarta.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String name; // 게시글 작성자 이름
    private String password; // 비밀번호

    // 여러 게시글이 하나의 게시판 주제를 가짐
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
