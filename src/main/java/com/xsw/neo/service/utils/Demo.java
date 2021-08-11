package com.xsw.neo.service.utils;

import com.xsw.neo.service.model.entity.Device;

/**
 * 静态bean工厂创建bean
 *
 * @author xueshengwen
 * @since 2021/8/11 10:30
 */
public class Demo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean());
        }
    }
}

/**
 * 静态bean工厂创建bean
 */
class BeanFactory {

    private static Device device = null;

    /**
     * 通过反射获取Bean
     *
     * @return
     * @throws Exception
     */
    public static Device getBean() {
        // 双检锁
        if (device == null) {
            synchronized (BeanFactory.class) {
                if (device == null) {
                    try {
                        device = (Device) Class.forName("com.xsw.neo.service.model.entity.Device").newInstance();
                        return device;
                    } catch (Exception e) {
                        throw new RuntimeException("BeanFactory get Bean error");
                    }
                }
            }
        }
        return device;
    }
}
