package Project.SocialCommerce.service;

import Project.SocialCommerce.dto.PostRequestDto;
import Project.SocialCommerce.dto.PostResponseDto;
import Project.SocialCommerce.model.Post;
import Project.SocialCommerce.model.User;
import Project.SocialCommerce.repository.PostRepository;
import Project.SocialCommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public void addPost(PostRequestDto postRequestDto, String email) {
        User user = userRepository.findByEmail(email).get();
        Post newPost = new Post();

        newPost.setContent(postRequestDto.getContent());
        newPost.setUser(user);

        postRepository.save(newPost);
    }

    public PostResponseDto getPost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new IllegalArgumentException("없는 게시물 입니다.");
        }
        return new PostResponseDto(post.get());

    }
}
