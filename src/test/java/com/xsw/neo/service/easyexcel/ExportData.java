package com.xsw.neo.service.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 导出
 *
 * @author xueshengwen
 * @since 2020/12/16 10:16
 */
@Data
public class ExportData {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "工资", index = 1)
    private Double wage;
}
