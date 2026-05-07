package com.yupi.yupao.exception;

import com.yupi.yupao.common.ErrorCode;

/**
 * 自定义异常类
 * 继承自RuntimeException，属于运行时异常
 * 用于处理业务逻辑中出现的异常情况
 */
public class BusinessException extends RuntimeException {

    // 错误码，用于标识具体的错误类型
    private final int code;

    // 错误描述，提供更详细的错误信息
    private final String description;

    /**
     * 构造方法1
     * @param message 异常信息
     * @param code 错误码
     * @param description 错误描述
     */
    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    /**
     * 构造方法2
     * @param ErrorCode 错误码对象，包含错误信息、错误码和错误描述
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    /**
     * 构造方法3
     * @param ErrorCode 错误码对象，包含错误信息和错误码
     * @param description 自定义的错误描述，会覆盖ErrorCode中的描述
     */
    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    /**
     * 获取错误码
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取错误描述
     * @return 错误描述
     */
    public String getDescription() {
        return description;
    }
}
