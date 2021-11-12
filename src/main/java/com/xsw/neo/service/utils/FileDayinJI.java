package com.xsw.neo.service.utils;

import java.awt.*;
import java.awt.print.*;

/**
 * @author xueshengwen
 * @since 2021/11/9 13:35
 */
public class FileDayinJI implements Printable {

    public static void main(String[] args) {
        int height = 175 + 3 * 15 + 20;
        Book book = new Book();
        // 打印格式
        PageFormat pf = new PageFormat();
        pf.setOrientation(PageFormat.PORTRAIT);
        // 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
        Paper p = new Paper();
        p.setSize(230, height);
        p.setImageableArea(5, -20, 230, height + 20);
        pf.setPaper(p);
        // 把 PageFormat 和 Printable 添加到书中，组成一个页面
        book.append(new FileDayinJI(), pf);
        // 获取打印服务对象
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(book);
        try {
            job.print();
        } catch (PrinterException e) {
            System.out.println("================打印出现异常");
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setFont(new Font("Default", Font.PLAIN, 10));
        g2d.drawString("联付科技", 50, 10);
        g2d.drawString("-------------------------------------", 7, 20);
        g2d.drawString("手机号码：" + "13888888888", 7, 35);
        g2d.drawString("领号日期：" + "2020.07.02", 7, 65);
        g2d.drawString("-------------------------------------", 7, 80);
        g2d.setFont(new Font("Default", Font.PLAIN, 18));
        g2d.drawString("测试代码", 7, 105);
        g2d.setFont(new Font("Default", Font.PLAIN, 10));
        g2d.drawString("停车场号码：" + "123456", 7, 175);
        g2d.drawString("-------------------------------------", 7, 145);
        g2d.drawString("*打印时间:" + "2020.07.02" + "*", 7, 160);
        g2d.drawString("*打印人员:" + "小张同学" + "*", 7, 200);
        return PAGE_EXISTS;
    }
}
