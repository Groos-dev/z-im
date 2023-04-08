package com.zx.im.service.group.model.req;

import com.zx.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 转让群
 * @author Mr.xin
 */
@Data
public class TransferGroupReq extends RequestBase {

    @NotNull(message = "群id不能为空")
    private String groupId;

    private String ownerId;

}
