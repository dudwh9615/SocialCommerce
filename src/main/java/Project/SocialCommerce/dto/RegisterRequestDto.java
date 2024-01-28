package Project.SocialCommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
