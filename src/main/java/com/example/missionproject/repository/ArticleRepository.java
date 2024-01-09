package com.example.missionproject.repository;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository <Article, Long> {
    List<Article> findByBoardAndTitleContainingIgnoreCase(Board board, String keyword);

    List<Article> findByBoardAndContentContainingIgnoreCase(Board board, String keyword);
}
