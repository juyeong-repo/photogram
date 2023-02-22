package com.juyeong.photogram.web.dto.auth;

import lombok.Data;

@Data
public class SignupReqDto {
    private String username;
    private String password;
    private String email;
    private String name;

    //role(필수), gender(선택) 등 추가정보는 추후 추가


}
