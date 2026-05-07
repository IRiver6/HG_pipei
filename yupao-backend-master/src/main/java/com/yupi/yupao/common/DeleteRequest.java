package com.yupi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求
 * 该类用于封装删除操作的请求参数，实现了Serializable接口以支持序列化
 *
 */
@Data // 使用Lombok注解，自动生成getter、setter、toString等方法
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = -5860707094194210842L; // 序列化版本UID，用于标识类的版本

    private long id; // 需要删除的记录ID
}
