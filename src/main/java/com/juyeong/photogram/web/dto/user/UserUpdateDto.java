package com.juyeong.photogram.web.dto.user;

import com.juyeong.photogram.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateDto {

    @NotBlank
    private String name;
    @NotBlank
    private String password;
    private String website;
    private String bio;
    private String phone;
    private String gender;


    // 추후 dto에서 받는 값은 변경될 예정, 이 항목들은 nullable 여부가 다르기 때문에 entity로 만들면 위험 -> 코드 수정 필요함
    public User toEntity() {
        return User.builder()
                .name(name) //validation check 필요
                .password(password) //validation check 필요
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }


}
