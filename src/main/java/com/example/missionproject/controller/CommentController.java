package com.example.missionproject.controller;

import com.example.missionproject.entity.Article;
import com.example.missionproject.service.ArticleService;
import com.example.missionproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("article")
public class CommentController {
    private final CommentService commentService;
    private final ArticleService articleService;

    // 댓글 작성하는 view로 이동
    @GetMapping("/{articleId}/comment")
    public String createView(@PathVariable("articleId") Long id, Model model) {
        Article article = articleService.readArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("articleId", id);
        return "comments/create";
    }

    // 댓글 작성하기
    @PostMapping("/{articleId}/comment")
    public String createComment(@RequestParam("name") String name,
                                @RequestParam("password") String password,
                                @RequestParam("content") String content,
                                @PathVariable("articleId") Long articleId) {
        commentService.createComment(name, password, content, articleId);
        return String.format("redirect:/article/%d", articleId);
    }
}
