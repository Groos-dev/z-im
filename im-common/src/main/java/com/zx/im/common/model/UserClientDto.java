package com.zx.im.common.model;

import lombok.Data;

/**
 * 用户连接信息
 */
@Data
public class UserClientDto {

    private Integer appId;

    private Integer clientType;

    private String userId;

    private String imei;

}
