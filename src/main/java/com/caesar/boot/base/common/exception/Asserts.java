package com.caesar.boot.base.common.exception;


import com.caesar.boot.base.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author caesar
 * @date 2021/11/27
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
