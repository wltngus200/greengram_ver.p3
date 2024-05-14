package com.green.greengramverp3.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@Builder
public class ResultDto <T>{
    private HttpStatus statusCode;
    private String resultMsg;
    private String result;
}
