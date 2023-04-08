
package com.zx.im.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author Mr.xin
 */
@Data
public class SyncResp<T> {

    private Long maxSequence;

    private boolean isCompleted;

    private List<T> dataList;

}
