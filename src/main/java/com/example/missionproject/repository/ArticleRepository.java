package com.example.missionproject.repository;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository <Article, Long> {
    // 전체 게시판 검색 결과 (검색 조건 - 제목)
    // 제목에 포함된 키워드를 찾음
    List<Article> findByTitleContaining(String keyword);

    // 전체 게시판 검색 결과 (검색 조건 - 내용)
    // 내용에 포함된 키워드 찾음
    List<Article> findByContentContaining(String keyword);

    // 특정 게시판 내 검색 결과 (검색 조건 - 제목)
    // 특정 게시판 내 검색 결과를 받아오기 위해 Board 데이터 필요
    List<Article> findByBoardAndTitleContaining(Board board, String keyword);

    // 특정 게시판 내 검색 결과 (검색 조건 - 내용)
    List<Article> findByBoardAndContentContaining(Board board, String keyword);
}
