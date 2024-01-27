package Project.SocialCommerce.dto;

import Project.SocialCommerce.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    private String email;
    private String pwd;
    private String name;
    private String profile;
    private String greetings;

}
