package com.example.Student.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //접근 제어자가 protected인 기본 생성자 자동으로 생성
public class Post {

    @Id
    private long id;
    private String title;
    private String content;

    @Builder //빌더 패턴으로 객체 생성
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
