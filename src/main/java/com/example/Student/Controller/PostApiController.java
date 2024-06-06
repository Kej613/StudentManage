package com.example.Student.Controller;

import com.example.Student.Dto.AddPostRequest;
import com.example.Student.Dto.PostResponse;
import com.example.Student.Dto.UpdatePostRequest;
import com.example.Student.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Student.Service.PostService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    //게시글 생성
    @PostMapping("/api/posts")
    public ResponseEntity<Post> addPost(@RequestBody AddPostRequest request) {
        Post savedPost = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }

    //게시글 전체 조회
    @GetMapping("/api/posts")
    public ResponseEntity<List<PostResponse>> findAllPosts() {
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(posts);
    }

    //게시글 선택 조회
    @GetMapping("/api/posts/{id}")
    public ResponseEntity<PostResponse> findPost(@PathVariable long id) {
        Post post = postService.findById(id);

        return ResponseEntity.ok()
            .body(new PostResponse(post));
    }
    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        postService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    //게시글 수정
    @PutMapping("/api/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long id, @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(id,request);

        return ResponseEntity.ok()
                .body(updatedPost);

    }

}
