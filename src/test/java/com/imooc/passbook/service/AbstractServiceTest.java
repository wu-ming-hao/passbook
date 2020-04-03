package com.imooc.passbook.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>服务测试对象基类</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractServiceTest {

    Long userId;

    @Before
    public void init(){
        userId = 0L;
    }

}
