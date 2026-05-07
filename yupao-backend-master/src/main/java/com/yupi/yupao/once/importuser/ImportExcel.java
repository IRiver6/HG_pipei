package com.yupi.yupao.once.importuser;

import com.alibaba.excel.EasyExcel;

import java.util.List;

/**
 * 导入 Excel
 * 该类用于实现Excel文件导入功能，提供了两种读取Excel数据的方式：监听器读取和同步读取
 */
public class ImportExcel {

    /**
     * 读取数据
     * 程序入口方法，用于测试Excel读取功能
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // todo 改测试文件
        String fileName = "E:\\星球项目\\yupao-backend\\src\\main\\resources\\testExcel.xlsx";
//        readByListener(fileName);
        synchronousRead(fileName);
    }

    /**
     * 监听器读取
     * 使用EasyExcel的监听器模式读取Excel文件，适用于大数据量读取
     * @param fileName Excel文件路径
     */
    public static void readByListener(String fileName) {
        // EasyExcel读取Excel文件，指定实体类为XingQiuTableUserInfo，使用自定义的TableListener监听器
        EasyExcel.read(fileName, XingQiuTableUserInfo.class, new TableListener()).sheet().doRead();
    }

    /**
     * 同步读
     * 使用EasyExcel的同步模式读取Excel文件，一次性读取所有数据到内存
     * @param fileName Excel文件路径
     */
    public static void synchronousRead(String fileName) {
        // 指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<XingQiuTableUserInfo> totalDataList =
                EasyExcel.read(fileName).head(XingQiuTableUserInfo.class).sheet().doReadSync();
        for (XingQiuTableUserInfo xingQiuTableUserInfo : totalDataList) {
            System.out.println(xingQiuTableUserInfo);
        }
    }

}
