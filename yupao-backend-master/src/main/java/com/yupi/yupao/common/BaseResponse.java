package com.yupi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 * 用于封装系统返回给前端的数据结构

 *
 * @param <T> 泛型类型，表示返回数据的类型
 */
@Data  // 使用Lombok的@Data注解自动生成getter、setter等方法
public class BaseResponse<T> implements Serializable {  // 实现Serializable接口以支持序列化

    // 状态码，表示操作结果的状态
    private int code;

    // 返回的数据内容，使用泛型以支持不同类型的数据
    private T data;

    // 简短的消息描述，通常用于表示操作结果的状态
    private String message;

    // 详细描述信息，提供更详细的错误或状态说明
    private String description;

    /**
     * 全参数构造方法
     * @param code 状态码
     * @param data 返回数据
     * @param message 消息描述
     * @param description 详细描述
     */
    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }
    

    /**
     * 三参数构造方法，description默认为空字符串
     * @param code 状态码
     * @param data 返回数据
     * @param message 消息描述
     */
    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    /**
     * 两参数构造方法，message和description默认为空字符串
     * @param code 状态码
     * @param data 返回数据
     */
    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    /**
     * 基于ErrorCode的构造方法
     * @param ErrorCode 预定义的错误码对象
     */
    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
    }
}
