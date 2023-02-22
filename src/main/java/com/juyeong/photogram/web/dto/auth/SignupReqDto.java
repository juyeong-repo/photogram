package com.juyeong.photogram.web.dto.auth;

import com.juyeong.photogram.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class SignupReqDto {
    private String username;
    private String password;
    private String email;
    private String name;

    //role(필수), gender(선택) 등 추가정보는 추후 추가

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }

}
