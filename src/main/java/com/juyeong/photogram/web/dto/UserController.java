package com.juyeong.photogram.web.dto;


import com.juyeong.photogram.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id) {
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("session info using annotation:::::::" + principalDetails.getUser());

        //직접 세션정보 찾아들어가서 꺼내오기 (추후 주석)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails =  (PrincipalDetails) auth.getPrincipal();
        System.out.println("session info from Security Context Holder ::::::::::" + mPrincipalDetails.getUser());
        return "user/update";
    }


}
