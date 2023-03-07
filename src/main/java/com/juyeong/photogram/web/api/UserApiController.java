package com.juyeong.photogram.web.api;

import com.juyeong.photogram.web.dto.user.UserUpdateDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PutMapping("/api/user/{id}")
    public String update(UserUpdateDto userUpdateDto) {
        // System.out.println("user 정보 수정 ::::::::::" + userUpdateDto);
        return "";
    }

}
