package com.juyeong.photogram.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{

    // 자바 런타임머신한테 알려줄 시리얼 번호 (객체 구분)
    private static final long serialVersionUID = 1L;

    private String message;
    private Map<String,String> errMap;

    // 생성자 하나 만들자
    public CustomValidationException(String message, Map<String,String> errMap) {
        super(message); //message는 getter 만들지않고 부모한테 던질 것
        this.message = message;
        this.errMap = errMap;
    }

    //getter 만들자
    public Map<String, String> getErrMap () {
        return errMap;
    }
}
