package com.www.acorn.exception;


import lombok.Data;

@Data
public class TokenRuntimeException extends RuntimeException{
    private String code="500";
    private String msg;


    public TokenRuntimeException (String msg){
            this.setMsg(msg);
    }



}
