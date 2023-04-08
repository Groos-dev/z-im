package com.zx.im.common.model.message;

import lombok.Data;

import java.util.List;

/**
 * @author Mr.xin
 */
@Data
public class GroupChatMessageContent extends MessageContent {

    private String groupId;

    private List<String> memberId;

}
