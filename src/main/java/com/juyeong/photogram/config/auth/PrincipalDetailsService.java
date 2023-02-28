package com.juyeong.photogram.config.auth;

import com.juyeong.photogram.domain.user.User;
import com.juyeong.photogram.domain.user.UserRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //IoC
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepositoty userRepositoty;

    //1.pw는 유저네임있으면 시큐리티가 알아서 비교해줌
    //2.리턴이 잘되면 자동으로 UserDetails 타입의 세션을 만듦
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User userEntity = userRepositoty.findByUsername(username);
        if (username == null) {
            return null;
        }else {
            return new PrincipalDetails(userEntity);
        }

    }
}
