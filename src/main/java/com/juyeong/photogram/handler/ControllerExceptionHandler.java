package com.juyeong.photogram.handler;

import com.juyeong.photogram.handler.ex.CustomValidationException;
import com.juyeong.photogram.util.Script;
import com.juyeong.photogram.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
       /* CMRespDto와 Script 비교
       * 1. 클라이언트(브라우저)에게 보여줄 때는 스크립트가 좋음
       * 2. 에이잭스로 통신하거나 안드로이드 통신 시 (개발자가 응답받음)에는 custrom response dto 가 좋음
       * 둘 중 어떤 방식이 나은지는 상황에 따라 판별하자
       * */


    return Script.back(e.getErrMap().toString());

        //return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrMap());
    }

}
