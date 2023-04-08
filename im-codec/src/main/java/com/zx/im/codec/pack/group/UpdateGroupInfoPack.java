package com.zx.im.codec.pack.group;

import lombok.Data;

/**
 * @author Mr.xin
 * @description 修改群信息通知报文
 **/
@Data
public class UpdateGroupInfoPack {

    private String groupId;

    private String groupName;

    // 是否全员禁言，0 不禁言；1 全员禁言。
    private Integer mute;

    //加入群权限，0 所有人可以加入；1 群成员可以拉人；2 群管理员或群组可以拉人。
    private Integer joinType;

    //群简介
    private String introduction;

    //群公告
    private String notification;

    //群头像
    private String photo;

    //群成员上限
    private Integer maxMemberCount;

    private Long sequence;
}
