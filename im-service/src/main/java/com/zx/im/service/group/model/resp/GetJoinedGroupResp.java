package com.zx.im.service.group.model.resp;

import com.zx.im.service.group.dao.ImGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @description 获取加入得群
 **/
@Data
public class GetJoinedGroupResp {

    private Integer totalCount;

    private List<ImGroupEntity> groupList;

}
