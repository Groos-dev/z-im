package com.zx.im.service.conversation.service;

import com.zx.im.common.ResponseVO;
import com.zx.im.common.model.SyncReq;
import com.zx.im.common.model.message.MessageReadedContent;
import com.zx.im.service.conversation.model.DeleteConversationReq;
import com.zx.im.service.conversation.model.UpdateConversationReq;

/**
 * @author Mr.xin
 */
public interface ConversationService {
    // 删除关系
    ResponseVO deleteConversation(DeleteConversationReq req);

    ResponseVO updateConversation(UpdateConversationReq req);

    ResponseVO syncConversationSet(SyncReq req);

    void messageMarkRead(MessageReadedContent messageContent);

    String convertConversationId(Integer type,String fromId,String toId);
}
