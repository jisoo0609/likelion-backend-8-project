package com.example.missionproject.repository;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository <Article, Long> {

    // 각 게시판 별 검색 결과 (검색 조건 - 제목)
    List<Article> findByBoardAndTitleContainingIgnoreCase(Board board, String keyword);

    // 각 게시판 별 검색 결과 (검색 조건 - 내용)
    List<Article> findByBoardAndContentContainingIgnoreCase(Board board, String keyword);

    // 전체 게시판 검색 결과 (검색 조건 - 제목)
    List<Article> findByTitleContaining(String keyword);

    // 전체 게시판 검색 결과 (검색 조건 - 내용)
    List<Article> findByContentContaining(String keyword);
}
