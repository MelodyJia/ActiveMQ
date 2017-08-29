package com.jia.templateService;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by jialianqing on 2017/5/9 0009.
 */
@Service
public class QueueConsumerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 接收消息
     */
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("From Queue ：\t" + destination.toString()+"\t" + "Receive Message：\t"
                    + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return tm;
    }
}
