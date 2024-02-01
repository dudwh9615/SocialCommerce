package Project.SocialCommerce.controller;

import Project.SocialCommerce.dto.CommentingRequestDto;
import Project.SocialCommerce.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<String> commenting(@RequestBody CommentingRequestDto requestDto, Principal principal) {
        commentService.addComment(requestDto, principal.getName());
        return ResponseEntity.ok("게시 완료");
    }

//    @GetMapping("/{postId}")
//    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId) {
//        return ResponseEntity.ok(postService.getPost(postId));
//    }

//    @PutMapping
//    public ResponseEntity<String> editPost(@RequestBody EditCommentRequestDto requestDto, Principal principal) {
//        commentService.editComment(requestDto, principal.getName());
//        return ResponseEntity.ok("게시글 수정 완료");
//    }
}
