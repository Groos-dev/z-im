package com.zx.im.common.model.message;

import com.zx.im.common.model.ClientInfo;
import lombok.Data;

/**
 * @author Mr.xin
 */
@Data
public class MessageReciveAckContent extends ClientInfo {

    private Long messageKey;

    private String fromId;

    private String toId;

    private Long messageSequence;


}
