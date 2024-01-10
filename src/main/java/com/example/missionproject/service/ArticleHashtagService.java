package com.example.missionproject.service;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.ArticleHashtag;
import com.example.missionproject.entity.Hashtag;
import com.example.missionproject.repository.ArticleHashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleHashtagService {
    private final ArticleHashtagRepository articleHashtagRepository;

    // Article과 Hashtag을 연결하는 ArticleHashtag 생성
    private List<ArticleHashtag> createArticleHashtags(Article article, List<Hashtag> hashtagList) {
        List<ArticleHashtag> articleHashtags = new ArrayList<>();

        for (Hashtag hashtag : hashtagList) {
            ArticleHashtag articleHashtag = new ArticleHashtag();
            articleHashtag.setArticle(article);
            articleHashtag.setHashtag(hashtag);
            articleHashtagRepository.save(articleHashtag);
            articleHashtags.add(articleHashtag);
        }

        return articleHashtags;
    }

}
