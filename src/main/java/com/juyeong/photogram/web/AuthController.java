package com.juyeong.photogram.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//인증
@Controller
public class AuthController {
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
    public String signup () {
        //csrf 토큰이 활성화되어 signin으로 이동못함
        return "auth/signin";
    }

}


