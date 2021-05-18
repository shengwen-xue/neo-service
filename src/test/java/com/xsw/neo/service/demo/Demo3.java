package com.xsw.neo.service.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author xueshengwen
 * @since 2021/5/17 10:17
 */
public class Demo3 {

    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("my-producer");
            producer.setNamesrvAddr("10.160.8.139:9876");
            producer.start();

            Message message = new Message("my_topic", "hello world".getBytes());
            SendResult send = producer.send(message);
            System.out.println("发送消息成功, 结果：" + send);

            producer.shutdown();
            System.out.println("生产者服务关闭！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
