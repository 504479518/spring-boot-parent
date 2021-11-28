package com.caesar.boot.base.common.api;

/**
 * 封装API的错误码
 *
 * @author caesar
 * @date 2021/11/19
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
