package com.xsw.neo.service.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xueshengwen
 * @since 2021/5/6 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1 {

    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        Assert.assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(10, calculator.sub(20, 10));
    }
}
