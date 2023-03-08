package com.juyeong.photogram.service;


import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.domain.user.UserRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    //DI
    private final UserRepositoty userRepositoty;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public User updateUserInfo (int id, User user) {

        //1.영속화
        // get() 무조건 찾음, orElseThrow() 못찾았으니 익셉션
        User userEntity = userRepositoty.findById(id).get();
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
