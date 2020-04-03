package com.imooc.passbook.service;

import com.imooc.passbook.vo.Pass;
import com.imooc.passbook.vo.Response;

/**
 * <h1>获取用户个人优惠卷信息</h1>
 */
public interface IUserPassService {

    /**
     * <h2>获取用户个人优惠卷信息，即我的优惠卷功能实现</h2>
     * @param userId 用户 id
     * @return {@link Response}
     */
    Response getUserPassInfo(Long userId) throws Exception;


    /**
     * <h2>获取用户已经消费了的优惠卷，即已经使用优惠卷功能实现</h2>
     * @param userId 用户id
     * @return {@link Response}
     */
    Response getUserUserPassInfo(Long userId) throws Exception;

    /**
     * <h2>获取用户所有的优惠卷</h2>
     * @param userId 用户id
     * @return {@link Response}
     */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * <h2>用户使用优惠卷</h2>
     * @param pass {@link Pass}
     * @return {@link Response}
     */
    Response userUserPass(Pass pass);

}
