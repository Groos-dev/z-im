package com.zx.im.service.friendship.service;

import com.zx.im.common.ResponseVO;
import com.zx.im.common.model.RequestBase;
import com.zx.im.common.model.SyncReq;
import com.zx.im.service.friendship.model.req.*;

/**
 * @author Mr.xin
 */
public interface ImFriendShipService {
    ResponseVO importFriendShip(ImporFriendShipReq req);

    ResponseVO addFriend(AddFriendReq req);

    ResponseVO doAddFriend(RequestBase req, String fromId, FriendDto toItem, Integer appId);

    ResponseVO updateFriend(UpdateFriendReq req);

    ResponseVO deleteFriend(DeleteFriendReq req);

    ResponseVO deleteAllFriend(DeleteFriendReq req);

    ResponseVO getAllFriendShip(GetAllFriendShipReq req);

    ResponseVO getRelation(GetRelationReq req);

    ResponseVO checkFriendship(CheckFriendShipReq req);

    ResponseVO addBlack(AddFriendShipBlackReq req);

    ResponseVO deleteBlack(DeleteBlackReq req);

    ResponseVO checkBlck(CheckFriendShipReq req);

    ResponseVO syncFriendshipList(SyncReq req);

}
