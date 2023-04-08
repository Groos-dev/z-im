
package com.zx.im.common.enums;

/**
 * @author Mr.xin
 */



public enum AllowFriendTypeEnum {

    /**
     * 验证
     */
    NEED(2),

    /**
     * 不需要验证
     */
    NOT_NEED(1),

    ;


    private final int code;

    AllowFriendTypeEnum(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
