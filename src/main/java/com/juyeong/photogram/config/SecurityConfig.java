package com.juyeong.photogram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //이 파일로 시큐리티 활성화
@Configuration //메모리에 띄우자 .ioc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode() {
        // IoC 할 때 빈이 주입되도록 객체를 heap에 생성
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super 삭제하면 기존 시큐리티가 가지고 있던 기능이 삭제됨

        http.csrf().disable();

        //인증안된 사람들은 로그인 페이지로 보내 (antMatchers에 있는 경로는 접근 못함)
        http.authorizeRequests()
                .antMatchers("/","/users/**", "/image/**", "/subscribe/**", "/comment/**",  "/api/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin") //get
                .loginProcessingUrl("/auth/signin") //post -> 스프링 시큐리티가 로그인 프로세스 진행
                .defaultSuccessUrl("/"); //http 403 상태코드: 요청 redirect 하여 defaultSuccessUrl 에서 loginPage로 이동
    }
}
