package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>统一的错误信息</h1>
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo<T> {

    /**  错误码 */
    public static final Integer ERROR = -1;

    /** 特点错误码 */
    private Integer code;

    /** 请求 Url */
    private String url;

    /** 错误信息 */
    private String massage;

    /** 请求返回数据 */
    private T data;
}
