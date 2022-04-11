package com.www.acorn.dto;

import com.www.acorn.enums.IErrorCode;
import com.www.acorn.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversalityDto<T> implements Serializable {

    private long code;
    private String msg;
    private T data;
    private boolean succeedFlag;

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> UniversalityDto<T> success(T data) {
        return new UniversalityDto<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data,true);
    }



    /**
     * 失败返回结果
     */
    public static <T> UniversalityDto<T> failed(IErrorCode errorCode) {
        return new UniversalityDto<T>(errorCode.getCode(), errorCode.getMessage(), null,false);
    }

    /**
     * 失败返回结果
     *  传入错误信息
     */
    public static <T> UniversalityDto<T> failed(String msg) {
        return new UniversalityDto<T>(ResultCode.FAILED.getCode(), msg, null,false);
    }


    /**
     * 失败返回结果
     *
     */
    public static <T> UniversalityDto<T> failed() {
        return new UniversalityDto<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null,false);
    }




}
