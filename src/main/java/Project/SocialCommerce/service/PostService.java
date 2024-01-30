package Project.SocialCommerce.service;

import Project.SocialCommerce.dto.PostRequestDto;
import Project.SocialCommerce.model.Post;
import Project.SocialCommerce.model.User;
import Project.SocialCommerce.repository.PostRepository;
import Project.SocialCommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
