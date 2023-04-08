package com.zx.im.codec.pack.conversation;

import lombok.Data;

/**
 * @author Mr.xin
 */
@Data
public class UpdateConversationPack {

    /**
     * 会话id
     */
    private String conversationId;

    /**
     * 是否屏蔽
     */
    private Integer isMute;

    /**
     * 是否置顶
     */
    private Integer isTop;

    /**
     * 会话类型
     */
    private Integer conversationType;

    private Long sequence;

}
