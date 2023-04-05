package com.juyeong.photogram.handler.ex;

import java.util.Map;

public class CustomApiException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CustomApiException(String message) {
        super(message);
    }
}
