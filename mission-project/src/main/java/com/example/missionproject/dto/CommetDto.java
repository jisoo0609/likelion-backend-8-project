package com.example.missionproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommetDto {
    private Long id;
    private String name; // 작성자
    private String password; // 비밀번호
    private String content; // 댓글 내용
}
