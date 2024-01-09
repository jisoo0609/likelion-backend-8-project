package com.example.missionproject.service;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.Comment;
import com.example.missionproject.repository.ArticleRepository;
import com.example.missionproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    // 댓글 작성하기
    public void createComment(String name, String password, String content, Long articleId) {
        // 주어진 정보로 새로운 댓글 생성
        Comment comment = new Comment();
        comment.setName(name);
        comment.setPassword(password);
        comment.setContent(content);

        // 게시글 찾음
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        // 댓글이 어느 게시글에 작성되어 있는지 게시글을 할당한다
        comment.setArticle(optionalArticle.orElse(null));
        // save
        commentRepository.save(comment);
    }

    // 전체 댓글 보여줌
    public List<Comment> readAllComment() {
        return commentRepository.findAll();
    }

    // 댓글 수정하기 위해 비밀번호 확인하는 메서드
    public boolean isPasswordCorrect(Long id, String password) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        // 가져온 댓글의 password와 입력받은 password가 일치하는지 확인
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            return comment.getPassword().equals(password);
        }
        return false;
    }

    // 댓글 삭제하기
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
