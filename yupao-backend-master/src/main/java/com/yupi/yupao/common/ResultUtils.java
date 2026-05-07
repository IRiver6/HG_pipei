package com.yupi.yupao.common;

/**
 * 返回工具类
 * 用于统一处理API返回结果，提供成功和失败的响应方法
 */
public class ResultUtils {

    /**
     * 成功响应方法
     * 用于返回操作成功的数据响应

     *
     * @param data 返回的数据对象
     * @param <T>  数据类型，支持泛型
     * @return 返回包含成功状态码、数据和消息的BaseResponse对象
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败响应方法
     * 使用预定义的错误码返回失败响应

     *
     * @param errorCode 预定义的错误码对象
     * @return 返回包含错误信息的BaseResponse对象
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败响应方法
     * 自定义错误码、消息和描述的失败响应

     *
     * @param code       自定义错误码
     * @param message    错误消息
     * @param description 错误描述
     * @return 返回包含错误信息的BaseResponse对象
     */
    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    /**
     * 失败响应方法
     * 使用预定义错误码并自定义消息和描述的失败响应

     *
     * @param errorCode   预定义的错误码对象

     * @param message    自定义错误消息
     * @param description 错误描述
     * @return 返回包含错误信息的BaseResponse对象
     */
    public static BaseResponse error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse(errorCode.getCode(), null, message, description);
    }

    /**
     * 失败响应方法
     * 使用预定义错误码并自定义描述的失败响应

     *
     * @param errorCode   预定义的错误码对象

     * @param description 错误描述
     * @return 返回包含错误信息的BaseResponse对象
     */
    public static BaseResponse error(ErrorCode errorCode, String description) {
        return new BaseResponse(errorCode.getCode(), errorCode.getMessage(), description);
    }
}

