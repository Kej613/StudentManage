package com.example.Student.Service;

import com.example.Student.Dto.AddPostRequest;
import com.example.Student.Dto.UpdatePostRequest;
import com.example.Student.Repository.PostRepository;
import com.example.Student.domain.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    //블로그 글 생성
    public Post save(AddPostRequest request) {
        return postRepository.save(request.toEntity());
    }

    //블로그 글 목록 조회
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));
    }

    //블로그 글 삭제
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    //블로그 글 수정
    @Transactional //트랜잭션은 데이터베이스에서 데이터를 바꾸기 위한 작업 단위를 말함
    public Post update(long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));

        post.update(request.getTitle(), request.getContent());
        return post;
    }

}
