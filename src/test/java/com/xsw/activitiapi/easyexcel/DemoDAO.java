package com.xsw.activitiapi.easyexcel;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author xueshengwen
 * @since 2020/12/16 10:19
 */
@Slf4j
public class DemoDAO {

    public void save(List<DemoData> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        String fileName = "D:\\my-doc\\1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }
}
