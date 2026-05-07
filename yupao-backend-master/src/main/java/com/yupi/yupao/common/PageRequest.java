package com.yupi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求参数
 * 该类实现了Serializable接口，支持序列化操作
 * 使用@Data注解自动生成getter、setter等方法
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -5860707094194210842L;  // 序列化版本ID，用于唯一标识类版本

    /**
     * 页面大小
     * 默认值为10，表示每页显示10条数据
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     * 默认值为1，表示从第一页开始
     */
    protected int pageNum = 1;
}
