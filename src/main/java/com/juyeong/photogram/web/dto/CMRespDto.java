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
    private String message;
    private Map<String, String> errMap;
}
