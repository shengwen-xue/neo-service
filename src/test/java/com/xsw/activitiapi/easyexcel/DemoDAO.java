package com.xsw.activitiapi.easyexcel;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据库操作
 *
 * @author xueshengwen
 * @since 2020/12/16 10:19
 */
@Slf4j
public class DemoDAO {

    public void save(List<ImportData> list) {
        list.forEach(System.out::println);
    }

    private static List<ExportData> exportData() {
        List<ExportData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExportData exportData = new ExportData();
            exportData.setName("张三" + i);
            exportData.setWage(10d + i);
            list.add(exportData);
        }
        return list;
    }

    public static void main(String[] args) {
        String fileName = "D:\\my-doc\\1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ImportData.class, new DemoDataListener()).sheet().doRead();

        // 导出
        // EasyExcel.write(fileName, ExportData.class).sheet("模板1").doWrite(exportData());
        // ExcelUtil.writeBySimple(filePath,data,head);
    }
}
