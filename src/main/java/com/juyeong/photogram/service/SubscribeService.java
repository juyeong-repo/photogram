package com.juyeong.photogram.service;

import com.juyeong.photogram.domain.subscribe.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SubscribeService {
    //구독, 취소시에 리턴타입을 우선은 void 필요한 파라미터 뭘까
    //두 명의 유저 정보 가져와
    //레포지토리 연결해서 실제 insert, delete 실행하기

    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void subscribe(int fromUserId, int toUserId) {
        //save 할 때 subscribe 객체가 필요하다 -> 근데 int 값으론 오브젝트 안되자너 .. 이럴 땐 네이티브 쿼리



    }


    @Transactional
    public void unSubscribe(int fromUserId, int toUserId) {


    }


}
