package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.confirm;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

public class ConfirmMessage {
    // number of messages
    public static final int MSG_CNT = 200;

    public static void main(String[] args) throws Exception {
        //调用单个确认发布方法 
        // 发布:200个单独确认消息，耗时:1492毫秒
       // confirmSingleMessage();
        // 发布:200个单独确认消息，耗时:174毫秒
        //confirmBatchMessage();
        //发布200个批量确认消息，一共耗时:78毫秒
        publishMessageAsync();

    }
    //异步消息发布确认
    public static void publishMessageAsync() throws Exception {
        Channel channel = ConnectionUtil.getChannel();
        //声明队列,此处使用UUID作为队列的名字
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        //开启发布确认模式
        channel.confirmSelect();
        //创建ConcurrentSkipListMap集合(跳表集合)
        ConcurrentSkipListMap<Long, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        //确认收到消息回调函数
        ConfirmCallback ackCallBack = new ConfirmCallback() {

            @Override
            public void handle(long deliveryTag, boolean multiple) throws IOException {
                //判断是否批量异步确认
                if (multiple) {
                    //把集合中没有被确认的消息添加到该集合中
                    ConcurrentNavigableMap<Long, String> confirmed = concurrentSkipListMap.headMap(deliveryTag, true);
                    //清除该部分没有被确认的消息
                    confirmed.clear();
                } else {
                    //只清除当前序列胡的消息
                    concurrentSkipListMap.remove(deliveryTag);

                }
                System.out.println("确认的消息序列序号:" + deliveryTag);
            }
        };

        //未被确认消息的回调函数
        ConfirmCallback nackCallBack = new ConfirmCallback() {
            @Override
            public void handle(long deliveryTag, boolean multiple) throws IOException {
                //获取没有被确认的消息
                String msg = concurrentSkipListMap.get(deliveryTag);
                System.out.println("发布的消息:" + msg + "未被确认，该消息序列号:" + deliveryTag);
            }
        };
        //添加异步确认监听器
        channel.addConfirmListener(ackCallBack, nackCallBack);
        //记录开始时间
        long start = System.currentTimeMillis();
        //循环发送消息
        for (int i = 0; i < MSG_CNT; i++) {
            //消息内容
            String message = "消息:" + i;
            //把未确认的消息放到集合中，通过序列号和消息进行关联
//            channel.getNextPublishSeqNo(); 获取下一个消息的序列号
            concurrentSkipListMap.put(channel.getNextPublishSeqNo(), message);
            //发送消息
            channel.basicPublish("", queueName, null, message.getBytes());

        }
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("发布"+MSG_CNT+"个批量确认消息，一共耗时:"+(end-start)+"毫秒");


    }



    public static void confirmBatchMessage() {
        try {
            //获取信道对象
            Channel channel = ConnectionUtil.getChannel();
            //开启确认发布
            channel.confirmSelect();
            //批量确认消息数量
            int batchSize=20;
            //未确认消息数量
            int nackMessageCount=0;
            //声明队列
            String queue = UUID.randomUUID().toString();
            //队列持久化
            channel.queueDeclare(queue, true, false, false, null);
            //发送消息
            long start = System.currentTimeMillis();
            for (int i = 0; i < MSG_CNT; i++) {
                String msg = "消息:" + i;
                //发送消息，消息需要持久化
                channel.basicPublish("", queue, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
                //累加未确认的发布数量
                nackMessageCount++;
                //判断的未确认消息数量和批量确认消息的数量是否一致
                if (nackMessageCount==batchSize){
                    //服务端返回false或者在超时时间内没有返回数据，生产者可以重新发送消息
                    boolean flag = channel.waitForConfirms();
                    if (flag) {
                        System.out.println("————————第" + (i + 1) + "条消息发送成功————————");
                    } else {
                        System.out.println("========第" + (i + 1) + "条消息发送失败=========");
                    }
                    //清空未确认发布消息个数
                    nackMessageCount=0;
                }
            }
            //为了确认剩下的是没有确认的消息，所以要再次进行确认
            if (nackMessageCount>0){
                //再次重新确认
                channel.waitForConfirms();
            }
            //记录结束时间
            long end = System.currentTimeMillis();
            System.out.println("发布:" + MSG_CNT + "个单独确认消息，耗时:" + (end - start) + "毫秒");


        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void confirmSingleMessage() {
        try {
            Channel channel = ConnectionUtil.getChannel();
            //开启确认发布
            channel.confirmSelect();
            //声明队列
            String queue = UUID.randomUUID().toString();

            channel.queueDeclare(queue, true, false, false, null);
            long start = System.currentTimeMillis();
            for (int i = 0; i < MSG_CNT; i++) {
                String msg = "消息: " + i;
                channel.basicPublish("", queue, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
                //服务端返回false或者在超时时间内没有返回数据，生产者可以重新发送消息
                boolean flag = channel.waitForConfirms();

                if (flag) {
                    System.out.println("————————第" + (i + 1) + "条消息发送成功————————");
                } else {
                    System.out.println("========第" + (i + 1) + "条消息发送失败=========");
                }
            }

            // 记录时间
            long end = System.currentTimeMillis();

            System.out.println("发布:" + MSG_CNT + "个单独确认消息，耗时:" + (end - start) + "毫秒");

        } catch (IOException | TimeoutException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
