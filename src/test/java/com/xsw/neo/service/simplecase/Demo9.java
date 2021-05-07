package com.xsw.neo.service.simplecase;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author xueshengwen
 * @since 2021/1/20 16:16
 */
public class Demo9 {
    private static final String HOST = "tcp://:1883";
    private static final String TOPIC = "";
    private static final String clientid = "";
    private MqttClient mqttClient;
    private MqttConnectOptions mqttConnectOptions;
    private String userName = "";
    private String passWord = "";

    private void start() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            mqttClient = new MqttClient(HOST, clientid, new MemoryPersistence());
            // MQTT的连接设置
            mqttConnectOptions = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            mqttConnectOptions.setCleanSession(true);
            // 设置连接的用户名
            mqttConnectOptions.setUserName(userName);
            // 设置连接的密码
            mqttConnectOptions.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            mqttConnectOptions.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            mqttConnectOptions.setKeepAliveInterval(20);
            // 设置回调
            mqttClient.setCallback(new PushCallback());
            MqttTopic topic = mqttClient.getTopic(TOPIC);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            mqttConnectOptions.setWill(topic, "close".getBytes(), 2, true);

            mqttClient.connect(mqttConnectOptions);
            //订阅消息
            int[] Qos = {1};
            String[] topic1 = {TOPIC};
            mqttClient.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo9 client = new Demo9();
        client.start();
    }
}
