package com.juyeong.photogram.web;

import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.service.AuthService;
import com.juyeong.photogram.web.dto.auth.SignupReqDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



//인증
@Controller
@RequiredArgsConstructor
public class AuthController {

    private static Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;
    /*    public AuthController (AuthService authService) {
        this.authService = authService;
    }*/

    @GetMapping("/auth/signup")
    public String signupForm () {
        return "auth/signup";
    }

    @GetMapping("/auth/signin")
    public String signinForm () {
        return "auth/signin";
    }


    // 회원가입 완료하면 로그인 화면으로 가세요
    @PostMapping("/auth/signup")
    public String signup (SignupReqDto signupReqDto) {
        User user = signupReqDto.toEntity();
        log.info(user.toString());
        authService.signUp(user);
        return "auth/signin";
    }

}


