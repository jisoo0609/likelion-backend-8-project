package com.example.missionproject.controller;

import com.example.missionproject.entity.Article;
import com.example.missionproject.entity.Comment;
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

    // 댓글 삭제 페이지로 이동
    @GetMapping("/{articleId}/comment/{commentId}/delete")
    public String deleteView(@PathVariable("articleId") Long articleId,
                             @PathVariable("commentId") Long id,
                             Model model) {
        // 댓글 읽어옴
        Comment comment = commentService.readComment(id);
        Article article = articleService.readArticle(articleId);

        model.addAttribute("comment", comment);
        model.addAttribute("article", article);
        return "comments/delete";
    }

    @PostMapping("/{articleId}/comment/{commentId}/delete")
    public String deleteComment(@PathVariable("articleId") Long articleId,
                                @PathVariable("commentId") Long id,
                                @RequestParam String password) {
        if (commentService.isPasswordCorrect(id, password)) {
            commentService.deleteComment(id);
            return String.format("redirect:/article/%d", articleId);
        } else {
            return String.format("redirect:/article/%d/comment/%d/delete?error=true", articleId, id);
        }
    }

    // 댓글 수정 페이지로 이동
    @GetMapping("/{articleId}/comment/{commentId}/update")
    public String updateView(@PathVariable("articleId") Long articleId,
                             @PathVariable("commentId") Long id,
                             Model model) {
        // 댓글 읽어옴
        Comment comment = commentService.readComment(id);
        Article article = articleService.readArticle(articleId);

        model.addAttribute("comment", comment);
        model.addAttribute("article", article);
        return "comments/update";
    }

    @PostMapping("/{articleId}/comment/{commentId}/update")
    public String updateComment(@PathVariable("articleId") Long articleId,
                                @PathVariable("commentId") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("password") String password,
                                @RequestParam("content") String content) {
        // 비밀번호가 일치하는 경우
        if (commentService.isPasswordCorrect(id, password)) {
            commentService.update(id, name, password, content);
            return String.format("redirect:/article/%d", articleId);
        } else {
            // 비밀번호가 일치하지 않는 경우
            return String.format("redirect:/article/%d/comment/%d/update?error=true", articleId, id);
        }
    }
}
