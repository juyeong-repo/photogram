package com.juyeong.photogram.web;

import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.handler.ex.CustomValidationException;
import com.juyeong.photogram.service.AuthService;
import com.juyeong.photogram.web.dto.auth.SignupReqDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


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
    public String signup (@Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
        // @controller지만 @responsebody 붙여 데이터 리턴할 수 있게 하자
        if(bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                errMap.put(err.getField(),err.getDefaultMessage());
                // System.out.println(err.getDefaultMessage());
            }
            throw new CustomValidationException("로그인 유효성검사 실패함", errMap);

        } else {
            User user = signupReqDto.toEntity();
            log.info(user.toString());
            authService.signUp(user);
            return "auth/signin";

        }

    }

}


