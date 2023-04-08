package com.zx.im.common;


/**
 * 支持多端接入
 * @author Mr.xin
 */

public enum ClientType {

    /**
     * 第三方接口
     */
    WEBAPI(0,"webApi"),
    WEB(1,"web"),
    IOS(2,"ios"),
    ANDROID(3,"android"),
    WINDOWS(4,"windows"),
    MAC(5,"mac"),
            ;

    private int code;
    private String error;

    ClientType(int code, String error){
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
