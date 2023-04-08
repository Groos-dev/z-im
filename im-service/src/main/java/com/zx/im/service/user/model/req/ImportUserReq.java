package com.zx.im.service.user.model.req;

import com.zx.im.common.model.RequestBase;
import com.zx.im.service.user.dao.ImUserDataEntity;
import lombok.Data;

import java.util.List;


@Data
public class ImportUserReq extends RequestBase {

    private List<ImUserDataEntity> userData;


}
