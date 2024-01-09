package com.example.missionproject.service;

import com.example.missionproject.entity.Article;
import com.example.missionproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    // 게시글 클릭하면 상세 게시글 보여줌
    public Article readArticle(Long id) {
        Optional <Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }

    // 게시글 수정하기 위해 비밀번호를 확인하는 메서드
    public boolean isPasswordCorrect(Long id, String password) {
        // 게시글을 가져옴
        Optional<Article> optionalArticle = articleRepository.findById(id);
        // 가져온 게시글의 password와 입력받은 password가 일치하는지 확인
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            return article.getPassword().equals(password);
        }
        return false;
    }

    // 업데이트
    public void update(Long id, String title, String content, String author, String password) {
        // 비밀번호가 일치하는 경우 대상 데이터 찾음
        Article target = readArticle(id);
        // 데이터의 내용을 전달받은 내용으로 갱신
        target.setTitle(title);
        target.setContent(content);
        target.setAuthor(author);
        target.setPassword(password);
        // save
        articleRepository.save(target);
    }

    // 게시글 삭제하기
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
