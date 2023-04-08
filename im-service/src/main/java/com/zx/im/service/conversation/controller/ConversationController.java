package com.zx.im.service.conversation.controller;

import com.zx.im.common.ResponseVO;
import com.zx.im.common.model.SyncReq;
import com.zx.im.service.conversation.model.DeleteConversationReq;
import com.zx.im.service.conversation.model.UpdateConversationReq;
import com.zx.im.service.conversation.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.xin
 */
@RestController
@RequestMapping("/v1/conversation")
public class ConversationController {
    @Autowired
    private ConversationService conversationService;
    @RequestMapping("/deleteConversation")
    public ResponseVO deleteConversation(@RequestBody @Validated DeleteConversationReq
                                                 req, Integer appId, String identifier)  {
        req.setAppId(appId);
        return conversationService.deleteConversation(req);
    }


    @RequestMapping("/updateConversation")
    public ResponseVO updateConversation(@RequestBody @Validated UpdateConversationReq
                                                 req, Integer appId, String identifier)  {
        req.setAppId(appId);
        return conversationService.updateConversation(req);
    }

    @RequestMapping("/syncConversationList")
    public ResponseVO syncFriendShipList(@RequestBody @Validated SyncReq req, Integer appId)  {
        req.setAppId(appId);
        return conversationService.syncConversationSet(req);
    }




}
