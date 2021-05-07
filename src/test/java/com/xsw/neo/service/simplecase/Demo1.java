package com.xsw.neo.service.simplecase;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpUtil;

/**
 * hutool工具类使用
 *
 * @author xueshengwen
 * @since 2020/12/22 13:29
 */
public class Demo1 {

    public static void main(String[] args) {
        String[] a = {"java", "c++", "c"};
        System.out.println(a);
        Console.log(a);

        String get = HttpUtil.get("http://localhost:8086/downloadExcel/fileLogPage?start=1&limit=5&type=");
        Console.log(get);


        MailAccount account = new MailAccount();
        account.setHost("smtp.exmail.qq.com");
        account.setPort(465);
        account.setAuth(true);
        account.setFrom("swxue@yihai-aspen.com");
        account.setUser("swxue@yihai-aspen.com");
        account.setPass("这里放授权码");
        account.setStarttlsEnable(true);
        MailUtil.send(account, CollUtil.newArrayList("xueshengwen@aliyun.com"), "测试", "邮件来自Hutool测试", false);


        String s = IdUtil.randomUUID();
        String s1 = IdUtil.simpleUUID();
        Console.log(s);
        Console.log(s1);
    }
}
