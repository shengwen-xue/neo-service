package com.xsw.neo.service.model.convert;

import com.xsw.neo.service.service.Pay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xueshengwen
 * @since 2021/5/31 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayContext {

    private Pay pay;

    public void payResult() {
        String pay = this.pay.pay();
        System.out.println(pay);
    }
}
