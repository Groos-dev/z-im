package com.zx.im.codec.pack.group;

import lombok.Data;

/**
 * @author Mr.xin
 * @description 踢人出群通知报文
 **/
@Data
public class RemoveGroupMemberPack {

    private String groupId;

    private String member;

}
