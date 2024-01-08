package com.example.missionproject.controller;


import com.example.missionproject.entity.Board;
import com.example.missionproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("board", board);
        return "boards/board-details";
    }

    @GetMapping("/{boardId}/article")
    public String createView(@PathVariable("boardId")Long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        model.addAttribute("boardId", id);
        return "boards/create-view";
    }

    @PostMapping("/{boardId}/article")
    public String create(@RequestParam("title") String title,
                         @RequestParam("content") String content,
                         @RequestParam("author") String author,
                         @RequestParam("password") String password,
                         @PathVariable("boardId") Long boardId) {
        boardService.create(title, content, author, password, boardId);
        return String.format("redirect:/boards/%d", boardId);
    }
}
