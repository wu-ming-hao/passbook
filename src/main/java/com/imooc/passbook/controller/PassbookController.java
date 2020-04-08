package com.imooc.passbook.controller;

import com.imooc.passbook.log.LogConstants;
import com.imooc.passbook.log.LogGenerator;
import com.imooc.passbook.service.IFeedbackServive;
import com.imooc.passbook.service.IGainPassTemplateService;
import com.imooc.passbook.service.IInventoryService;
import com.imooc.passbook.service.IUserPassService;
import com.imooc.passbook.vo.Feedback;
import com.imooc.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.vo.Pass;
import com.imooc.passbook.vo.Response;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1> Passbook Rest Controller </h1>
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class PassbookController {

    /** 用户优惠卷服务 */
    private final IUserPassService userPassService;

    /** 优惠卷库存服务 */
    private final IInventoryService iInventoryService;

    /** 领取优惠卷服务 */
    private final IGainPassTemplateService gainPassTemplateService;

    /** 反馈服务 */
    private final IFeedbackServive feedbackServive;

    /** HttpServletRequest */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService, IInventoryService iInventoryService, IGainPassTemplateService gainPassTemplateService, IFeedbackServive feedbackServive, HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.iInventoryService = iInventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackServive = feedbackServive;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 获取用户个人优惠卷信息
     * @param userId 用户id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/userpassinfo")
    Response userPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(httpServletRequest, userId, LogConstants.ActionName.USER_PASS_INFO, null);
        return userPassService.getUserUserPassInfo(userId);
    }

    /**
     * <h2>获取用户使用了的优惠卷信息</h2>
     * @param userId 用户id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/useruserpassinfo")
    Response userUserPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(httpServletRequest, userId, LogConstants.ActionName.USER_USED_PASS_INFO, null);
        return userPassService.getUserUserPassInfo(userId);
    }

    /**
     * <h2>用户使用优惠卷</h2>
     * @param pass {@link Pass}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/useruserpass")
    Response userUserPass(Pass pass) {
        LogGenerator.genLog(httpServletRequest, pass.getUserId(), LogConstants.ActionName.USER_USE_PASS, pass);
        return userPassService.userUserPass(pass);
    }


    /**
     *  <h2>获取库存信息</h2>
     * @param userId 用户id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    Response inventoryInfo(Long userId) throws Exception{
        LogGenerator.genLog(httpServletRequest,userId,LogConstants.ActionName.INVENTORY_INFO,null);
        return iInventoryService.getInventoryInfo(userId);
    }

    /**
     * <h2>用户领取优惠卷</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/gainpasstemplate")
    Response gainPassTemplate(@RequestBody GainPassTemplateRequest request) throws Exception{
        LogGenerator.genLog(httpServletRequest,request.getUserId(),LogConstants.ActionName.GAIN_PASS_TEMPLATE,request);
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
     * <h2>用户创建评论</h2>
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/createfeedback")
    Response createFeedback(@RequestBody Feedback feedback) throws Exception{
        LogGenerator.genLog(httpServletRequest,feedback.getUserId(),LogConstants.ActionName.CREATE_FEEDBACK,feedback);
        return feedbackServive.createFeedback(feedback);
    }

    /**
     * <h2>用户获取评论信息</h2>
     * @param userId 用户id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/getfeedback")
    Response getFeedback(Long userId) throws Exception{
        LogGenerator.genLog(httpServletRequest,userId,LogConstants.ActionName.GET_FEEDBACK,null);
        return feedbackServive.getFeedback(userId);
    }

    /**
     * <h2>异常演示接口</h2>
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception{
        throw new Exception("Welcome To IMOOC");
    }

}
