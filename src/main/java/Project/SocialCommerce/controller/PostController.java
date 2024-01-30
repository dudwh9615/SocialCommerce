package Project.SocialCommerce.controller;

import Project.SocialCommerce.dto.PostRequestDto;
import Project.SocialCommerce.dto.PostResponseDto;
import Project.SocialCommerce.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> posting(@RequestBody PostRequestDto postRequestDto, Principal principal) {
        postService.addPost(postRequestDto, principal.getName());
        return ResponseEntity.ok("게시 완료");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }
//
//    @PutMapping
//    public ResponseEntity<String> editPost(@RequestBody EditPostRequestDto editPostRequestDto, Principal principal) {
//        postService.editPost(editPostRequestDto, principal.getName());
//        return ResponseEntity.ok("게시글 수정 완료");
//    }

}