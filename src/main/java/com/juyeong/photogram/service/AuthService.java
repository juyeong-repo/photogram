package com.juyeong.photogram.service;

import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.domain.user.UserRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // IoC, 트랜잭션 관리
@RequiredArgsConstructor
public class AuthService {

    private final UserRepositoty userRepository;
    public User signUp(User user) {
        // 회원가입
        User userEntity = userRepository.save(user);
        return userEntity;
    }

}
