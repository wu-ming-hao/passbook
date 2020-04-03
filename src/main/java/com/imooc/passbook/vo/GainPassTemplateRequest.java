package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户领取优惠卷的请求对象</h1>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GainPassTemplateRequest {

    /** 用户Id */
    private Long userId;

    /** PassTempalte 对象 */
    private PassTemplate passTemplate;
}
