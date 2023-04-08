package com.zx.im.codec.pack.friendship;

import lombok.Data;

/**
 * @author Mr.xin
 * @description: 删除好友通知报文,多端同步
 **/
@Data
public class DeleteFriendPack {

    private String fromId;

    private String toId;

    private Long sequence;
}
