package com.yupi.yupao.exception;

import com.yupi.yupao.common.BaseResponse;
import com.yupi.yupao.common.ErrorCode;
import com.yupi.yupao.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * 用于统一处理系统中出现的各种异常，提供统一的异常响应格式
 */
@RestControllerAdvice  //声明这是一个全局异常处理器，会捕获所有Controller层抛出的异常
@Slf4j  //Lombok日志注解，用于在类中生成日志器
public class GlobalExceptionHandler {



    /**
     * 处理业务异常
     * @param e 业务异常对象
     * @return 返回统一的错误响应格式
     */
    @ExceptionHandler(BusinessException.class)  //捕获所有BusinessException类型的异常
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);  //记录业务异常的错误日志
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());  //返回统一的错误响应
    }



    /**
     * 处理运行时异常
     * @param e 运行时异常对象
     * @return 返回统一的错误响应格式
     */
    @ExceptionHandler(RuntimeException.class)  //捕获所有RuntimeException类型的异常
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);  //记录运行时异常的错误日志
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage(), "");  //返回统一的系统错误响应
    }
}
