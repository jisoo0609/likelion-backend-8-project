package com.example.missionproject.controller;


import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.ArticleHashtag;
import com.example.missionproject.entity.Board;
import com.example.missionproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    // /boards를 실행하면 게시판 목록이 보여짐
    // 자유 게시판, 개발 게시판, 일상 게시판, 사건사고 게시판
    @GetMapping
    public String boardList(Model model) {
        List<Board> boards = boardService.readAllBoard();
        model.addAttribute("boards", boards);
        return "boards/board-list";
    }

    // 각 게시판에 저장되어있는 게시글 불러옴
    @GetMapping("/{boardId}")
    public String boardDetails(@PathVariable("boardId") Long id, Model model) {
        Board board = boardService.getBoardById(id);

        // 정렬된 게시글 리스트를 생성
        List<Article> sortedArticles = board.getArticles().stream()
                .sorted(Comparator.comparing(Article::getId).reversed())
                .collect(Collectors.toList());
        model.addAttribute("board", board);
        model.addAttribute("sortedArticles", sortedArticles);
        return "boards/board-details";
    }

    @GetMapping("/{boardId}/article")
    public String createView(@PathVariable("boardId")Long id, Model model) {
        Board board = boardService.getBoardById(id);

        // 게시판 전체 이름 가져옴
        List<Board> boards = boardService.readAllBoard();

        model.addAttribute("boards", boards);
        model.addAttribute("board", board);
        model.addAttribute("boardId", id);
        return "boards/create-view";
    }

    // 게시글 생성하기
    @PostMapping("/{boardId}/article")
    public String create(@RequestParam("title") String title,
                         @RequestParam("content") String content,
                         @RequestParam("author") String author,
                         @RequestParam("password") String password,
                         @RequestParam("boardId") Long boardId
    ) {
        boardService.create(title, content, author, password, boardId);
        return String.format("redirect:/boards/%d", boardId);
    }

    // 게시판 전체에서 게시글 검색하기
    @GetMapping("/search")
    public String searchAll(@RequestParam("type") String type,
                            @RequestParam("keyword") String keyword,
                            Model model) {
        List <Article> searchArticle = boardService.searchAllBoards(type, keyword);
        model.addAttribute("searchResult", searchArticle);
        return "boards/search-all";
    }

    // 게시판 내 게시글 검색하기
    @GetMapping("/{boardId}/search")
    public String searchPage(@PathVariable("boardId") Long id,
                             @RequestParam("type") String type,
                             @RequestParam("keyword") String keyword,
                             Model model) {
        List<Article> searchArticle= boardService.searchArticles(id, type, keyword);
        model.addAttribute("boardId", id);
        model.addAttribute("searchResult", searchArticle);
        return "boards/search";
    }
}
