package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.constant.FeedbackType;
import com.imooc.passbook.vo.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>用户反馈服务测试</h1>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FeedbackServiceTest extends AbstractServiceTest {

    @Autowired
    private IFeedbackServive feedbackServive;

    @Test
    public void testCreateFeedback() {
        Feedback appFeedback = new Feedback();
        appFeedback.setUserId(userId);
        appFeedback.setType(FeedbackType.APP.getCode());
        appFeedback.setTemplateId("-1");
        appFeedback.setComment("慕课网学习分布式卡包应用！");
        System.out.println(JSON.toJSONString(feedbackServive.createFeedback(appFeedback)));

        Feedback passFeedback = new Feedback();
        passFeedback.setUserId(userId);
        appFeedback.setType(FeedbackType.PASS.getCode());
        appFeedback.setTemplateId("asdasd");
        appFeedback.setComment("优惠卷评论");
        System.out.println(feedbackServive.createFeedback(passFeedback));


    }

    @Test
    public void TestGetFeedback() {
        System.out.println(feedbackServive.getFeedback(userId));
    }

}
