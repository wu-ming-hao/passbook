package com.imooc.passbook.service;

import com.imooc.passbook.vo.Response;

/**
 * <h1>获取库存信息：值返回用户没有领取的，即优惠卷库存功能实现接口定义</h1>
 */
public interface IInventoryService {

    /**
     *<h2>获取库存信息</h2>
     * @param userId 用户id
     * @return {@link Response}
     */
    Response getInventoryInfo(Long userId) throws Exception;

}
