package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>库存请求响应</h1>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    /** 用户Id */
    private Long userId;

    /** 优惠卷模板信息 */
    private List<PassTemplateInfo> passTemplateInfos;

}
