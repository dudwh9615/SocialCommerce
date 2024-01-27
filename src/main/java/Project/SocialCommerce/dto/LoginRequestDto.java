package Project.SocialCommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String pwd;
}
