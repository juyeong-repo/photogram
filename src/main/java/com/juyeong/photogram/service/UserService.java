package com.juyeong.photogram.service;


import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.domain.user.UserRepositoty;
import com.juyeong.photogram.handler.ex.CustomException;
import com.juyeong.photogram.handler.ex.CustomValidationApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    //DI

    @Autowired
    private final UserRepositoty userRepositoty;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



//유저 서비스에서 회원피드에 보여줄 내용이 있어야함
    public User memberProfile (int userId) {
        User userEntity = userRepositoty.findById(userId).orElseThrow(()->{
                throw new CustomException("유효하지 않은 회원정보 : 해당 프로필 페이지는 없는 페이지입니다.");
                });
        return userEntity;
    }


    @Transactional
    public User updateUserInfo (int id, User user) {

        //1.영속화
        // get() 무조건 찾음, orElseThrow() 못찾았으니 익셉션 (get() -> orELseThrow로 수정)

       User userEntity = userRepositoty.findById(id).orElseThrow(() -> { return new CustomValidationApiException("찾을 수 없는 id입니다.");});
       System.out.println("===================check================="+userEntity.toString());


        // 2.더티체킹
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity;
    }
}

