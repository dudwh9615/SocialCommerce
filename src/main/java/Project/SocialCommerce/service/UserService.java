package Project.SocialCommerce.service;

import Project.SocialCommerce.dto.*;
import Project.SocialCommerce.model.User;
import Project.SocialCommerce.repository.UserRepository;
import Project.SocialCommerce.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequestDto requestDto) {
        String email = requestDto.getEmail();
        String pwd = passwordEncoder.encode(requestDto.getPwd());

        // 회원 중복 확인
        Optional<User> checkDuplicate = userRepository.findByEmail(email);
        if (checkDuplicate.isPresent()){
            throw new IllegalArgumentException("중복 이메일 입니다.");
        }
        // 유저 등록
        User user = new User(email, pwd, requestDto.getName(), requestDto.getProfile(), requestDto.getGreetings());
        userRepository.save(user);
    }

    public UserResponseDto findByEmail(String email) {
        Optional<User> res = userRepository.findByEmail(email);
        if (res.isEmpty()) {
            throw new IllegalArgumentException("등록된 이메일이 없습니다.");
        }

        return UserResponseDto.toDto(res.get());
    }

    //새로 추가
    public void login(LoginRequestDto requestDto, HttpServletResponse res) {
        String email = requestDto.getEmail();
        String pwd = requestDto.getPwd();

        // 사용자 확인
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        // 비밀번호 확인
        if (!passwordEncoder.matches(pwd, user.getPwd())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // JWT 생성 및 쿠키에 저장 후 Response 객체에 추가
        String token = jwtUtil.createToken(user.getEmail());
        jwtUtil.addJwtToCookie(token, res);
    }
}
