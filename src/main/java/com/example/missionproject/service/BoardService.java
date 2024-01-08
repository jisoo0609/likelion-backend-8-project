package com.example.missionproject.service;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.Board;
import com.example.missionproject.repository.ArticleRepository;
import com.example.missionproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;


    // 게시판 종류 가져와 보여줌
    public List<Board> readAllBoard() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElse(null);
    }

    // 게시글 생성하는 메서드
    public void create(
            String title,
            String content,
            String author,
            String password,
            // 게시판의 PK 가져옴
            Long boardId) {
        // 주어진 정보로 새로운 Article 객체 생성
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        article.setPassword(password);

        // 게시판 이름을 찾는다
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        // 게시글이 어느 게시판에 작성되는지 게시판을 할당한다
        article.setBoard(optionalBoard.orElse(null));
        // save
        articleRepository.save(article);
    }
}