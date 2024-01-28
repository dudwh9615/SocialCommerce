package Project.SocialCommerce.dto;

import Project.SocialCommerce.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class RegisterRequestDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String pwd;

    @NotBlank
    private String name;

    @NotBlank
    private String profile;

    @NotBlank
    private String greetings;

}
