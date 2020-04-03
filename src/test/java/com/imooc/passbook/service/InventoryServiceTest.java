package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InventoryServiceTest extends AbstractServiceTest {

    @Autowired
    private IInventoryService inventoryService;

    public void testGetInventoruyInfo() throws Exception{
        System.out.println(JSON.toJSONString(inventoryService.getInventoryInfo(userId), SerializerFeature.DisableCircularReferenceDetect));
    }

}
