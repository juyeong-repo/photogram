package com.juyeong.photogram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //이 파일로 시큐리티 활성화
@Configuration //메모리에 띄우자 .ioc
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super 삭제하면 기존 시큐리티가 가지고 있던 기능이 삭제됨
        //인증안된 사람들은 로그인 페이지로 보내
        http.authorizeRequests()
                .antMatchers("/","/users/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .defaultSuccessUrl("/"); //http 403 상태코드: 요청 redirect 하여 defaultSuccessUrl 에서 loginPage로 이동
    }
}
