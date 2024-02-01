package Project.SocialCommerce.service;

import Project.SocialCommerce.dto.LikeCommentDto;
import Project.SocialCommerce.dto.LikePostDto;
import Project.SocialCommerce.model.Comment;
import Project.SocialCommerce.model.Interaction;
import Project.SocialCommerce.model.Post;
import Project.SocialCommerce.model.User;
import Project.SocialCommerce.repository.CommentRepository;
import Project.SocialCommerce.repository.InteractionRepository;
import Project.SocialCommerce.repository.PostRepository;
import Project.SocialCommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InteractionService {

    private final InteractionRepository interactionRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void likesComment(LikeCommentDto dto, String email) {
        Interaction likes = new Interaction();
        Optional<Comment> commentOpt = commentRepository.findById(dto.getCommentId());
        if (commentOpt.isEmpty()) {
            throw new IllegalArgumentException("댓글이 존재하지 않습니다.");
        }
        Comment comment = commentOpt.get();
        Optional<Post> postOpt = postRepository.findById(comment.getPost().getId());
        if (postOpt.isEmpty()) {
            throw new IllegalArgumentException(("댓글이 달린 게시물이 존재하지 않습니다."));
        }
        Post post = postOpt.get();
        User user = userRepository.findByEmail(email).get();
        likes.setComment(comment);
        likes.setUser(user);

        interactionRepository.save(likes);
    }

    public void likesPost(LikePostDto dto, String email) {
        Interaction likes = new Interaction();
        Optional<Post> postOpt = postRepository.findById(dto.getPostId());
        if (postOpt.isEmpty()) {
            throw new IllegalArgumentException(("게시물이 존재하지 않습니다."));
        }
        Post post = postOpt.get();
        User user = userRepository.findByEmail(email).get();
        likes.setPost(post);
        likes.setUser(user);

        interactionRepository.save(likes);
    }
}
