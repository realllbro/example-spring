package com.example.configuration.http;

import lombok.Data;

/**
 * 공통으로 사용할 응답 클래스
 */
@Data
public class BaseResponse<T> {
    private BaseResponseCode code;
    private String message;
    private T data;

    // 호출성공일때 사용
    public BaseResponse(T data){
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }
    
    // 예외처리에서 사용
    public BaseResponse(BaseResponseCode code, String message){
        this.code = code;
        this.message = message;
    }


}
