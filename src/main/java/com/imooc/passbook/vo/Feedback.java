package com.imooc.passbook.vo;

import com.google.common.base.Enums;
import com.imooc.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

/**
 * <h1>用户评论</h1>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    /** 用户id */
    private Long userId;

    /** 评论类型 */
    private String type;

    /** Passtemplate RowKey ,如果是 app 类型的评论，则没有 */
    private String templateId;

    /** 评论内容 */
    private String comment;

    public boolean validate(){
        FeedbackType feedbackType = Enums.getIfPresent(FeedbackType.class,this.type.toUpperCase()).orNull();
        return !(null == feedbackType || null == comment);
    }
}
