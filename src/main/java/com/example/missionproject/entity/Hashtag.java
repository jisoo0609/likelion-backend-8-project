package com.example.missionproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hashtag;

    // 해시태그와 게시글 다대 다 관계
    @OneToMany(mappedBy = "hashtag")
    private List<ArticleHashtag> articleHashtags = new ArrayList<>();
}
