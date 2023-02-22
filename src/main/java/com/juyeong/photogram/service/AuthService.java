package com.juyeong.photogram.service;

import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.domain.user.UserRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // IoC, 트랜잭션 관리
@RequiredArgsConstructor
public class AuthService {

    private final UserRepositoty userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public User signUp(User user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); // 관리자 ROLE_ADMINß

        // 회원가입
        User userEntity = userRepository.save(user);
        return userEntity;
    }

}
