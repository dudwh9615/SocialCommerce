package Project.SocialCommerce.controller;

import Project.SocialCommerce.dto.LoginRequestDto;
import Project.SocialCommerce.dto.RegisterRequestDto;
import Project.SocialCommerce.dto.UserRequestDto;
import Project.SocialCommerce.dto.UserResponseDto;
import Project.SocialCommerce.model.User;
import Project.SocialCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<RegisterRequestDto> register(@RequestBody RegisterRequestDto requestDto) {
        //UserService 호출해서 회원가입
        userService.register(requestDto);
        return ResponseEntity.ok(requestDto);
    }

//    @PostMapping("/login")
//    public ResponseEntity<LoginRequestDto> login(@RequestBody LoginRequestDto loginRequestDto) {
//        userService.login(loginRequestDto, );
//        return ResponseEntity.
//    }

}
