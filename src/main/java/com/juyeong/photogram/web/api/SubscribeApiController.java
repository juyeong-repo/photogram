package com.juyeong.photogram.web.api;


import com.juyeong.photogram.config.auth.PrincipalDetails;
import com.juyeong.photogram.service.SubscribeService;
import com.juyeong.photogram.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class SubscribeApiController {

     /*데이터만 리턴, 구독하기 / 구독끊기
     * 현재 누가 누구를 구독하고 있는지 정보가 있어야한다.
     * -> 지금 로그인 한 사람이 구독하는 걸로 할것임 -> principalDetails에 있는 정보 가져와
     * */


    private final SubscribeService subscribeService;


    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId) {
       // int result =
        subscribeService.subscribe(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(new CMRespDto<>(1,"구독 성공", null), HttpStatus.OK);
    }

    @DeleteMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unSubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId) {
       //  int result =
        subscribeService.unSubscribe(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(new CMRespDto<>(1,"구독취소 성공", null), HttpStatus.OK);
    }

}
