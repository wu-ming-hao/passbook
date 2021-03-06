package com.imooc.passbook.utils;

import com.imooc.passbook.vo.Feedback;
import com.imooc.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * <h1> RowKey 生成器工具类</h1>
 */
@Slf4j
public class RowKeyGenUtil {

    /**
     * <h2> 根据提供的 PassTemplate 对象生成 RowKey </h2>
     *
     * @param passTemplate {@link PassTemplate}
     * @return string RowKey
     */
    public static String genPassTemplateRowKey(PassTemplate passTemplate) {
        String passInfo = String.valueOf(passTemplate.getId()) + "_" + passTemplate.getTitle();
        String rowkey = DigestUtils.md5Hex(passInfo);
        log.info("genPassTemplateRowKey:{},{}", passInfo, rowkey);
        return rowkey;
    }

    /**
     * <h2>根据提供的优惠卷请求生成RowKey，只可以在领取优惠卷的时候使用</h2>
     * Pass RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     * @param request {@link GainPassTemplateRequest}
     * @return string Rowkey
     */
    public static String genPassRowKey(GainPassTemplateRequest request){

        return new StringBuffer(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }

    /**
     * <h2> 根据Feedback 构造 Rowkey</h2>
     * @param feedback {@link Feedback}
     * @return  string RoWKey
     */
    public static String getFeedbackRowKey(Feedback feedback) {
        return new StringBuffer(String.valueOf(feedback.getUserId())).reverse().toString() + (Long.MAX_VALUE - System.currentTimeMillis());

    }
}
