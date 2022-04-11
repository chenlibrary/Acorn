package com.www.acorn.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class TokenRuntimeException extends RuntimeException{
    private String code="500";
    private String msg;


    public TokenRuntimeException (String msg){
            this.setMsg(msg);
    }



}
