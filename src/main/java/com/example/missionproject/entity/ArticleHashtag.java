package com.example.missionproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// 연결 테이블용 엔티티
@Entity
@Getter
@Setter
public class ArticleHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
}
