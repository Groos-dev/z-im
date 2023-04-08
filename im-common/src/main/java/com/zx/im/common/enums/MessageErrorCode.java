package com.zx.im.common.enums;


import com.zx.im.common.exception.ApplicationExceptionEnum;

/**
 * @author Mr.xin
 */

public enum MessageErrorCode implements ApplicationExceptionEnum {


    FROMER_IS_MUTE(50002,"发送方被禁言"),

    FROMER_IS_FORBIBBEN(50003,"发送方被禁用"),




    ;

    private int code;
    private String error;

    MessageErrorCode(int code, String error){
        this.code = code;
        this.error = error;
    }
    public int getCode() {
        return this.code;
    }

    public String getError() {
        return this.error;
    }

}
