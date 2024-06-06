package com.example.Student.Dto;

import com.example.Student.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@NoArgsConstructor
@Getter
public class AddPostRequest { //화면에 보여질 DTO, 데이터 전달용

    private String title;
    private String content;

    public Post toEntity() {
     return Post.builder()
             .title(title)
             .content(content)
             .build();
    }

}
