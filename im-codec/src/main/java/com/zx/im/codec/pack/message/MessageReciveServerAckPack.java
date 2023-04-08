package com.zx.im.codec.pack.message;

import lombok.Data;

/**
 * @author Mr.xin
 */
@Data
public class MessageReciveServerAckPack {

    private Long messageKey;

    private String fromId;

    private String toId;

    private Long messageSequence;

    private Boolean serverSend;
}
