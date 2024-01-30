package Project.SocialCommerce.controller;

import Project.SocialCommerce.dto.PostRequestDto;
import Project.SocialCommerce.model.Post;
import Project.SocialCommerce.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

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

//    @GetMapping
//    public ResponseEntity<PostResponseDto> getPost(@RequestBody GetPostRequestDto getPostRequestDto) {
//        return postService.getPost(getPostRequestDto);
//    }
//
//    @PutMapping
//    public ResponseEntity<String> editPost(@RequestBody EditPostRequestDto editPostRequestDto, Principal principal) {
//        postService.editPost(editPostRequestDto, principal.getName());
//        return ResponseEntity.ok("게시글 수정 완료");
//    }

}