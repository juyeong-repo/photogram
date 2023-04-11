package com.juyeong.photogram.handler.ex;

import java.util.Map;

public class CustomException extends RuntimeException{

    // 자바 런타임머신한테 알려줄 시리얼 번호 (객체 구분)
    private static final long serialVersionUID = 1L;

    private String message;


    // 생성자 하나 만들자
    public CustomException(String message) {
        super(message); //message는 getter 만들지않고 부모한테 던질 것
        this.message = message;

    }

}
