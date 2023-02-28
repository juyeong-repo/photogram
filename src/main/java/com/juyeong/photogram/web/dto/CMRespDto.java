package com.juyeong.photogram.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMRespDto <T>{
    //custom response Dto

    private int code; //1 성공, -1 실패
    private String message;
    private T data;
}
