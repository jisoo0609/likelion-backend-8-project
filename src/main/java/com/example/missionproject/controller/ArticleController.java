package com.example.missionproject.controller;


import com.example.missionproject.entity.Article;
import com.example.missionproject.service.ArticleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {
    private final ArticleService articleService;

    // 게시글 상세보기
    @GetMapping("{articleId}")
    public String readArticle(@PathVariable("articleId") Long id, Model model) {
        Article article = articleService.readArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("boardId", article.getBoard().getId());
        return "articles/article-view";
    }

    // 게시글 수정 페이지로 이동
    @GetMapping("{articleId}/update")
    public String updateView(@PathVariable("articleId")Long id, Model model) {
        Article article = articleService.readArticle(id);
        model.addAttribute("article", article);
        return "articles/update";
    }

    @PostMapping("{articleId}")
    public String updateArticle(
            @PathVariable("articleId") Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("author") String author,
            @RequestParam("password") String password) {
        // 비밀번호가 일치하는 경우
        if (articleService.isPasswordCorrect(id, password)) {
            articleService.update(id, title, content, author, password);
            return String.format("redirect:/article/%d", id);
        } else {
            // 비밀번호 일치하지 않는 경우
            return String.format("redirect:/article/%d/update?error=true", id);
        }
    }

    // 게시글 삭제하기
    @GetMapping("{articleId}/delete")
    public String deleteView(@PathVariable("articleId") Long id, Model model) {
        Article article = articleService.readArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("boardId", article.getBoard().getId());
        return "articles/delete";
    }

    @PostMapping("{articleId}/delete")
    public String deleteArticle(@PathVariable("articleId") Long id,
                                @RequestParam String password,
                                @RequestParam Long boardId) {
        if (articleService.isPasswordCorrect(id, password)) {
            articleService.deleteArticle(id);
            return String.format("redirect:/boards/%d", boardId);
        } else {
            return String.format("redirect:/article/%d/delete?error=true", id);
        }
    }
}
