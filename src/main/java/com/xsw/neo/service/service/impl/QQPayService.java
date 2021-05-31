package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.service.Pay;

/**
 * @author xueshengwen
 * @since 2021/5/31 16:21
 */
public class QQPayService implements Pay {
    @Override
    public String pay() {
        return "QQ支付";
    }
}
