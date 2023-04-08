package com.zx.im.common.model;

import lombok.Data;


/**
 * @author Mr.xin
 */
@Data
public class RequestBase {
    private Integer appId;

    private String operater;

    private Integer clientType;

    private String imei;
}
