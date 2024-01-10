package com.example.missionproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 게시판
@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 게시판 종류

   // 하나의 게시판이 여러개의 게시글을 가짐
    @OneToMany(mappedBy = "board")
    private List<Article> articles;

}
