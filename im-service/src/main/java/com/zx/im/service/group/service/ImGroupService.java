package com.zx.im.service.group.service;


import com.zx.im.common.ResponseVO;
import com.zx.im.common.model.SyncReq;
import com.zx.im.service.group.dao.ImGroupEntity;
import com.zx.im.service.group.model.req.*;

/**
 * @description
 * @author Mr.xin
 * @version 1.0
 */
public interface ImGroupService {

    public ResponseVO importGroup(ImportGroupReq req);

    public ResponseVO createGroup(CreateGroupReq req);

    public ResponseVO updateBaseGroupInfo(UpdateGroupReq req);

    public ResponseVO getJoinedGroup(GetJoinedGroupReq req);

    public ResponseVO destroyGroup(DestroyGroupReq req);


    /**
     * 转让群
     * @param req
     * @return
     */
    public ResponseVO transferGroup(TransferGroupReq req);

    public ResponseVO<ImGroupEntity> getGroup(String groupId, Integer appId);

    public ResponseVO getGroup(GetGroupReq req);

    public ResponseVO muteGroup(MuteGroupReq req);

    ResponseVO syncJoinedGroupList(SyncReq req);

    Long getUserGroupMaxSeq(String userId, Integer appId);
}
