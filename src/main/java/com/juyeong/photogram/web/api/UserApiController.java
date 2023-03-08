package com.juyeong.photogram.web.api;

import com.juyeong.photogram.config.auth.PrincipalDetails;
import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.handler.ex.CustomValidationApiException;
import com.juyeong.photogram.handler.ex.CustomValidationException;
import com.juyeong.photogram.service.UserService;
import com.juyeong.photogram.web.dto.CMRespDto;
import com.juyeong.photogram.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable int id,
                               @Valid UserUpdateDto userUpdateDto,
                               BindingResult bindingResult,
                               @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if(bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                errMap.put(err.getField(),err.getDefaultMessage());
                System.out.println("=========================");
                System.out.println(err.getDefaultMessage());
                System.out.println("=========================");
            }
            throw new CustomValidationApiException("로그인 유효성검사 실패함", errMap);

        }else {
            User userEntity = userService.updateUserInfo(id, userUpdateDto.toEntity());
            // 세션 정보 변경
            principalDetails.setUser(userEntity);
            return new CMRespDto<>(1, "회원수정완료", userEntity);
        }

    }

}
