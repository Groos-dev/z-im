package com.zx.im.codec.proto;

import lombok.Data;

/**
 * 自定义消息协议头
 * @author Mr.xin
 */
@Data
public class MessageHeader {
    // 消息操作指令使用十六进制表示 一个消息的开始通常使用0x 开始
    // 4 字节
    private Integer command;

    // 版本号 - 4字节
    private Integer version;

    // 端类型 - 4字节
    private Integer clientType;

    // 应用id
    private Integer appId;

    // 消息体解析类型 0x0 json, 0x1 protubuf 默认使用json
    private Integer messageType = 0x0;

    // imei长度
    private Integer imeiLength;
    // 消息体长度
    private Integer length;

    // imei号
    private String imei;
}
