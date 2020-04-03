package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>用户领取的优惠卷</h1>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pass {

    /** 用户 id */
    private Long UserId;

    /** pass在HBase 中的 RowKey */
    private String rowKey;

    /** PassTemplate 在HBase中的 RowKey */
    private String templateId;

    /** 优惠卷token，又可能是null，则填充-1 */
    private String token;

    /** 领取日期 */
    private Date assignedDate;

    /** 消费日期，不为空代表已经消费了 */
    private Date conDate;

}
