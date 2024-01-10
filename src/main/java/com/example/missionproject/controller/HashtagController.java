package com.example.missionproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("hashtag")
public class HashtagController {
    // 해시태그 클릭 시 /hashtag로 넘어옴
    @GetMapping("/{hashtagId}")
    public String hashtagView(@PathVariable("hashtagId") Long id, Model model) {
        return "hashtags/hashtag-view";
    }
}
