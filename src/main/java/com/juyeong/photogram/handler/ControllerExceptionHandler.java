package com.juyeong.photogram.handler;

import com.juyeong.photogram.handler.ex.CustomValidationException;
import com.juyeong.photogram.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public CMRespDto<?> validationException(CustomValidationException e) {
            //리턴타입에 제네릭 추론을 사용하여 <?> 라고만 적어도 ok
        return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrMap());
    }

}
