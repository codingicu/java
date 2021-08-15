package com.demo.rabbitmq.work.fair;

import com.demo.rabbitmq.Factory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 工作队列-公平-生产者示例
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class Provider {
    /**
     * 队列名称
     */
    private final static String QUEUE = "work-fair";
    /**
     * 消息
     */
    private final static String MESSAGE = "Hello RabbitMQ";
    /**
     * 发送数量
     */
    private final static int NUM = 10;

    public static void main(String[] args) {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = Factory.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE, false, false, false, null);
            for (int i = 0; i < NUM; i++) {
                channel.basicPublish("", QUEUE, null, (MESSAGE + i).getBytes());
                System.out.println("发送消息为：" + (MESSAGE + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.close(channel, connection);
        }
    }
}
