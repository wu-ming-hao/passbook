package com.imooc.passbook.controller;

import com.imooc.passbook.log.LogConstants;
import com.imooc.passbook.log.LogGenerator;
import com.imooc.passbook.service.IUserService;
import com.imooc.passbook.vo.Response;
import com.imooc.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>创建用户服务</h1>
 */
@Slf4j
@Service
@RequestMapping("/passbook")
public class CreateUserController {

    /** 创建用户服务 */
    private final IUserService userPassService;

    /** HttpServletRequest */
    private HttpServletRequest httpServletRequest;

    @Autowired
    public CreateUserController(IUserService userPassService1, HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService1;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * <h2>创建用户</h2>
     * @param user {@link User}
     * @return  {@link Response}
     */
    @ResponseBody
    @PostMapping("/createuser")
    Response createUser(@RequestBody User user) throws Exception{
        LogGenerator.genLog(httpServletRequest,1L, LogConstants.ActionName.CREATE_USER,user);
        return userPassService.createUser(user);
    }

}
