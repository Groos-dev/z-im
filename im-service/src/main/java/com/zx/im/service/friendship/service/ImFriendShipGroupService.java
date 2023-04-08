package com.zx.im.service.friendship.service;


import com.zx.im.common.ResponseVO;
import com.zx.im.service.friendship.dao.ImFriendShipGroupEntity;
import com.zx.im.service.friendship.model.req.AddFriendShipGroupReq;
import com.zx.im.service.friendship.model.req.DeleteFriendShipGroupReq;

/**
 * @author Mr.xin
 * @description:
 **/
public interface ImFriendShipGroupService {

    public ResponseVO addGroup(AddFriendShipGroupReq req);

    public ResponseVO deleteGroup(DeleteFriendShipGroupReq req);

    public ResponseVO<ImFriendShipGroupEntity> getGroup(String fromId, String groupName, Integer appId);


}
