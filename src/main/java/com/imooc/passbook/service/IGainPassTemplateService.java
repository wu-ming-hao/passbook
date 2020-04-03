package com.imooc.passbook.service;

import com.imooc.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.vo.Response;

/**
 * <h1>用户领取优惠卷功能实现</h1>
 */
public interface IGainPassTemplateService {


    /**
     * <h2>用户领取优惠卷</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}
