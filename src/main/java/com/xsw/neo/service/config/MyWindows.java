package com.xsw.neo.service.config;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xueshengwen
 * @since 2021/6/25 15:13
 */
public class MyWindows extends Frame {


    public static void main(String[] args) {
        MyWindows win = new MyWindows();

        win.setTitle("我的窗口");
        win.setLocation(200, 100);
        win.setSize(500, 300);
        win.setVisible(true);
        // 设置窗口居中
        win.setLocationRelativeTo(null);

        // 流式布局
        win.setLayout(new FlowLayout());

        // 创建文本框 可以存20个字符
        TextField textField = new TextField(200);

        // 创建按钮
        Button button = new Button("submit");

        // 创建文本域
        TextArea textArea = new TextArea(10, 40);

        // 组件添加到窗体
        win.add(textField);
        win.add(button);
        win.add(textArea);

        // 对按钮添加事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取文本框的值
                String str = textField.getText().trim();
                // 清空数据
                textField.setText("");

                // 设置给文本域
                // ta.setText(tf_str);

                // 字符串比较
                if (str.equals("123")) {
                    // 追加和换行
                    textArea.append("123" + "\r\n");
                } else
                    textArea.append("输错了" + "\r\n");

                // 获取光标
                textField.requestFocus();
            }


        });

        win.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
