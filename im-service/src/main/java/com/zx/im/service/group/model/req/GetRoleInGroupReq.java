package com.zx.im.service.group.model.req;

import com.zx.im.common.model.RequestBase;
import lombok.Data;

import java.util.List;

/**
 **/
@Data
public class GetRoleInGroupReq extends RequestBase {

    private String groupId;

    private List<String> memberId;
}
