package com.example.missionproject.service;

import com.example.missionproject.entity.Hashtag;
import com.example.missionproject.repository.ArticleHashtagRepository;
import com.example.missionproject.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HashtagService {
    private final HashtagRepository hashtagRepository;

    // 해시태그 생성하는 메서드
    private List<Hashtag> createHashtag(String hashtags) {
        List<Hashtag> hashtagList = new ArrayList<>();

        // 해시태그 문자열을 분할하여 각 해시태그 생성
        String[] hashtagArray = hashtags.split("#");
        for (String hashtagText : hashtagArray) {
            Hashtag hashtag = new Hashtag();
            hashtag.setHashtag(hashtagText.trim()); // trim()으로 앞뒤 공백 제거
            hashtagRepository.save(hashtag);
            hashtagList.add(hashtag);
        }

        return hashtagList;
    }
}
