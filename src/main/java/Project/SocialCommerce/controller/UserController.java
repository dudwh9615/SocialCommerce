package Project.SocialCommerce.controller;

import Project.SocialCommerce.dto.*;
import Project.SocialCommerce.model.User;
import Project.SocialCommerce.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequestDto requestDto) {
        //UserService 호출해서 회원가입
        userService.register(requestDto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PutMapping("/users")
    public ResponseEntity<String> modifyUserInfo(@RequestBody @Valid ModifyRequestDto modifyRequestDto, Principal principal) {
        userService.modifyUserInfo(modifyRequestDto, principal.getName());
        return ResponseEntity.ok("회원정보 수정 완료");
    }

    @PostMapping("/following")
    public ResponseEntity<String> followUser(@RequestBody FollowRequestDto followRequestDto, Principal principal) {
        String loginUserEmail = principal.getName();
        userService.following(loginUserEmail, followRequestDto);
        return ResponseEntity.ok("팔로우 성공");
    }

    @PostMapping("/unfollowing")
    public ResponseEntity<String> unFollowUser(@RequestBody FollowRequestDto followRequestDto, Principal principal) {
        String loginUserEmail = principal.getName();
        userService.unFollowing(loginUserEmail, followRequestDto);
        return ResponseEntity.ok("팔로우 취소");
    }


//    @PostMapping("/login")
//    public void login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse res) {
//        userService.login(loginRequestDto, );
//        return ResponseEntity.
//    }

}
