package com.zx.im.common.model.message;

import com.zx.im.common.model.ClientInfo;
import lombok.Data;
/**
 * @author Mr.xin
 * @description 消息已读
 */
@Data
public class MessageReadedContent extends ClientInfo {

    private long messageSequence;

    private String fromId;

    private String groupId;

    private String toId;

    private Integer conversationType;

}
