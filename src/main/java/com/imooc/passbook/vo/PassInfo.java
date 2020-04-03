package com.imooc.passbook.vo;

import com.imooc.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户领取的优惠卷信息</h1>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassInfo {

    /** 优惠卷 */
    private Pass pass;

    /** 优惠卷模板 */
    private PassTemplate passTemplate;

    /** 优惠卷对应的商户 */
    private Merchants merchants;

}
