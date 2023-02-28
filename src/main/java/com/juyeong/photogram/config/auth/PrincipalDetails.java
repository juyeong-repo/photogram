package com.juyeong.photogram.config.auth;

import com.juyeong.photogram.domain.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;

    //생성자
    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //권한 : 한개가 아닐 수 있으므로 콜렉션 타입이 디폴트로 되어있음
        Collection<GrantedAuthority> collector = new ArrayList<>();
        //collector에 권한 (람다)
        collector.add (() -> { return user.getRole();}
        );



        return collector;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() { //이 계정 만료됐니
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //잠겼니
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
