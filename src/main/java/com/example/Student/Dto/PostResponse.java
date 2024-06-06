package com.example.Student.Dto;

import com.example.Student.domain.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private final String title;
    private final String content;

    public PostResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
