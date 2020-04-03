package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * <h1> 消费kafka 中的 Passtemplate </h1>
 */
@Slf4j
@Component
public class CousumePasstemplate {

    /**
     * pass 相关的 HBase 服务
     */
    private final IHBasePassService passService;

    @Autowired
    public CousumePasstemplate(IHBasePassService passService) {
        this.passService = passService;
    }


    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})
    public void receice(@Payload String passtempalte,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Consumer Receive PassTempate:{},", passtempalte);

        PassTemplate pt = null;
        try {
            pt = JSON.parseObject(passtempalte, PassTemplate.class);
        } catch (Exception e) {
            log.error("Parse  PassTemplate Error:{]", e.getMessage());
        }

        log.info("DropPasstemplateToHBase:{}", passService.dropPassTemplateToHBase(pt));
    }

}
