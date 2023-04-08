package com.zx.im.service.friendship.service;


import com.zx.im.common.ResponseVO;
import com.zx.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.zx.im.service.friendship.model.req.DeleteFriendShipGroupMemberReq;

/**
 * @author Mr.xin
 * @description:
 **/
public interface ImFriendShipGroupMemberService {

    public ResponseVO addGroupMember(AddFriendShipGroupMemberReq req);

    public ResponseVO delGroupMember(DeleteFriendShipGroupMemberReq req);

    public int doAddGroupMember(Long groupId, String toId);

    public int clearGroupMember(Long groupId);
}
