package com.zx.im.service.friendship.model.resp;

import lombok.Data;

import java.util.List;


/**
 * @author Mr.xin
 */
@Data
public class ImportFriendShipResp {

    private List<String> successId;

    private List<String> errorId;
}
