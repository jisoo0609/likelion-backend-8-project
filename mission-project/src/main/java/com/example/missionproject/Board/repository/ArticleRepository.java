package com.example.missionproject.Board.repository;

import com.example.missionproject.Board.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository <Article, Long> {
}
