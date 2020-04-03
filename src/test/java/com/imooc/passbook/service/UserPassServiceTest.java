package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.Pass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserPassServiceTest extends AbstractServiceTest {

    @Autowired
    private IUserPassService userPassService;

    @Test
    public void testGetUserPassInfo() throws Exception {
        System.out.println(JSON.toJSONString(userPassService.getUserUserPassInfo(userId)));
    }

    @Test
    public void TestGetUserUserPassInfo() throws Exception {
        System.out.println(JSON.toJSONString(userPassService.getUserUserPassInfo(userId)));
    }

    @Test
    public void TestGetUserAllPassInfo() throws Exception {
        System.out.println(JSON.toJSONString(userPassService.getUserAllPassInfo(userId)));
    }

    @Test
    public void TestUserUserPass() {
        Pass pass = new Pass();
        pass.setUserId(userId);
        pass.setTemplateId("");
        System.out.println(JSON.toJSONString(userPassService.userUserPass(pass)));
    }
}
