package com.yupi.yupao.model.enums;

/**
 * 队伍状态枚举
 * 定义了队伍的三种状态：公开、私有和加密
 */
public enum TeamStatusEnum {

    // 公开状态，值为0
    PUBLIC(0, "公开"),
    // 私有状态，值为1
    PRIVATE(1, "私有"),
    // 加密状态，值为2
    SECRET(2, "加密");

    // 存储枚举的整数值
    private int value;

    // 存储枚举的文本描述
    private String text;


    /**
     * 根据整数值获取对应的枚举对象
     * @param value 整数值
     * @return 匹配的枚举对象，如果没有匹配则返回null
     */
    public static TeamStatusEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }
        // 获取所有枚举值
        TeamStatusEnum[] values = TeamStatusEnum.values();
        // 遍历枚举值，查找匹配的枚举
        for (TeamStatusEnum teamStatusEnum : values) {
            if (teamStatusEnum.getValue() == value) {
                return teamStatusEnum;
            }
        }
        return null;
    }

    /**
     * 枚举构造函数
     * @param value 整数值
     * @param text 文本描述
     */
    TeamStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 获取枚举的整数值
     * @return 整数值
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置枚举的整数值
     * @param value 整数值
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 获取枚举的文本描述
     * @return 文本描述
     */
    public String getText() {
        return text;
    }

    /**
     * 设置枚举的文本描述
     * @param text 文本描述
     */
    public void setText(String text) {
        this.text = text;
    }
}
