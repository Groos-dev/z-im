package com.zx.im.service.friendship.model.req;

import com.zx.im.common.model.RequestBase;
import lombok.Data;


/**
 * @description 好友申请
 * @author Mr.xin
 */
@Data
public class ApproverFriendRequestReq extends RequestBase {

    private Long id;

    //1同意 2拒绝
    private Integer status;
}
