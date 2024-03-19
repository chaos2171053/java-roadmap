package com.example.sbredismysqlrbmqseckill.mqservice;

import com.example.sbredismysqlrbmqseckill.bean.MessageSend;
import com.example.sbredismysqlrbmqseckill.config.MyRabbitMQConfig;
import com.example.sbredismysqlrbmqseckill.service.MessageSendService;
import com.example.sbredismysqlrbmqseckill.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MQStockService {
    @Autowired
    private StockService stockService;
    @Autowired
    private MessageSendService messageSendService;

    /**
     * 监听库存消息队列，并消费
     * @param messageSend
     */
    @RabbitListener(queues = MyRabbitMQConfig.STOCK_QUEUE)
    @Transactional
    public void decrByStock(MessageSend messageSend) {
        log.info("库存消息队列收到的消息商品信息是：{}", messageSend.toString());
        /**
         * 调用数据库service给数据库对应商品库存减一
         */
        stockService.decrByStock(messageSend.getStockName());


        MessageSend updateMessageSend = new MessageSend();
        BeanUtils.copyProperties(messageSend, updateMessageSend);
        updateMessageSend.setStatus("以扣减库存");
        log.info("库存消息队列更新消息表 {}",updateMessageSend.toString());
        messageSendService.updateMessageSendStatus(updateMessageSend);

        }

    }
}
