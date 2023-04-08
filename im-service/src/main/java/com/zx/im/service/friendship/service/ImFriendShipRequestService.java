package com.zx.im.service.friendship.service;


import com.zx.im.common.ResponseVO;
import com.zx.im.service.friendship.model.req.ApproverFriendRequestReq;
import com.zx.im.service.friendship.model.req.FriendDto;
import com.zx.im.service.friendship.model.req.ReadFriendShipRequestReq;

/**
 * @author Mr.xin
 */
public interface ImFriendShipRequestService {
    ResponseVO addFienshipRequest(String fromId, FriendDto toItem, Integer appId);

    ResponseVO approverFriendRequest(ApproverFriendRequestReq req);

    ResponseVO getFriendRequest(String fromId, Integer appId);

    ResponseVO readFriendShipRequestReq(ReadFriendShipRequestReq req);
}
