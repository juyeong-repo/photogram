package com.juyeong.photogram.handler.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException{

    // 자바 런타임머신한테 알려줄 시리얼 번호 (객체 구분)
    private static final long serialVersionUID = 1L;

    private Map<String,String> errorMap;

    // 생성자 하나 만들자
    public CustomValidationApiException(String message) {
        super(message); //message는 getter 만들지않고 부모한테 던질 것
    }

    public CustomValidationApiException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

    //getter 만들자
    public Map<String, String> getErrMap () {
        return errorMap;
    }
}
