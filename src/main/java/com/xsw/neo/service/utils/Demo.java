package com.xsw.neo.service.utils;

import com.xsw.neo.service.model.entity.Device;

import java.io.IOException;
import java.util.Properties;

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

//        System.out.println("=================================");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(BeanFactory2.getBean());
//        }
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


class BeanFactory2 {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory2.class.getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("init Properties error!");
        }
    }

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
                        String deviceAddress = properties.getProperty("device");
                        device = (Device) Class.forName(deviceAddress).newInstance();
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
