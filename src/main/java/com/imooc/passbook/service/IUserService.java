package com.imooc.passbook.service;

import com.imooc.passbook.vo.Response;
import com.imooc.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <h1> 用户服务：创建User服务 </h1>
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * @param user {@link User}
     * @return {@link Response}
     */
    Response createUser(User user) throws Exception;
}
