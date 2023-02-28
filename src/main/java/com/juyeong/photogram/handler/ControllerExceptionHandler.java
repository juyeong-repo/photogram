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
    public CMRespDto<Map<String, String>> validationException(CustomValidationException e) {

        return new CMRespDto(-1, e.getMessage(), e.getErrMap());
    }

}
