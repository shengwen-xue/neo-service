package com.xsw.neo.service.simplecase;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 测试类：mqtt
 *
 * @author xueshengwen
 * @since 2021/3/15 10:56
 */
@Slf4j
public class Test {

    private MqttClient client;

    private MqttConnectOptions options;

    private ScheduledExecutorService scheduledExecutorService;

    private String host = "";

    private String clientId = "12345677900";

    private String topic = "";

    private String apiKey = "";

    private String secretKey = "";

    public void mqttInit() {
        try {
            // host为主机 clientId为客户端唯一标识id  MemoryPersistence设置clientId的保存形式  默认以内存保存
            client = new MqttClient(host, clientId, new MemoryPersistence());
            // mqtt连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session 这里设置false表示服务器会保存客户端的连接记录  这里设置true表示每次连接到服务器都是以新的身份连接
            options.setCleanSession(false);
            // 这里设置用户名&企业id
            options.setUserName(apiKey);
            // 这里设置密码
            options.setPassword(secretKey.toCharArray());
            // 这里设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 这里设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线 但是这个方法并没有重连机制
            options.setKeepAliveInterval(20);
            // 这里设置自动连接
            options.setAutomaticReconnect(true);
            // 设置回调
            client.setCallback(new MqttCallback() {

                @Override
                public void connectionLost(Throwable throwable) {
                    // 连接丢失后在这里进行重连
                    System.out.println("connectionLost:[连接失败！尝试重连]");
                }

                @Override
                public void messageArrived(String topicName, MqttMessage message) throws Exception {
                    // 订阅后得到的消息会执行到这里
                    System.out.println("messageArrived:[收到消息!]");
                    log.info("clientId:{}, topic:{}, Qos:{}, content:{}", clientId, topic, message.getQos(), new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    // 发布后会执行到这
                    System.out.println("deliveryComplete" + iMqttDeliveryToken.isComplete());
                }
            });
            log.info("初始化成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mqttConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 如果还未连接
                    if (!client.isConnected()) {
                        client.connect(options);
                        client.subscribe(topic, 1);
                    }
                    log.info("订阅成功!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void startReconnect() {
        try {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    if (!client.isConnected()) {
                        mqttInit();
                    }
                }
            }, 0 * 1000, 10 * 1000, TimeUnit.MILLISECONDS);
            log.info("startReconnect连接成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        test.startReconnect();
        test.mqttInit();
        test.mqttConnection();
    }
}
