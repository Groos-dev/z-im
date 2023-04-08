package com.zx.im.codec.proto;

import lombok.Data;

/**
 * @author Mr.xin
 */
@Data
public class Message {
    private MessageHeader messageHeader;
    private Object messagePack;
}
