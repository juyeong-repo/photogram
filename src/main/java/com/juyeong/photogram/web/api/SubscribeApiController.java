package com.juyeong.photogram.web.api;


import com.juyeong.photogram.config.auth.PrincipalDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeApiController {

     /*데이터만 리턴, 구독하기 / 구독끊기
     * 현재 누가 누구를 구독하고 있는지 정보가 있어야한다.
     * -> 지금 로그인 한 사람이 구독하는 걸로 할것임 -> principalDetails에 있는 정보 가져와
     * */

    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int id) {
        return null;
    }

    @DeleteMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unSubscribe() {
        return null;
    }

}
