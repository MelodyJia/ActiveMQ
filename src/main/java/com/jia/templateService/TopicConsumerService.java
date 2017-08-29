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
public class TopicConsumerService {

    @Resource(name="jmsTemplate1")
    private JmsTemplate jmsTemplate1;

    /**
     * 接收消息
     */
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate1.receive(destination);
        try {
            System.out.println("From Topic ：\t" + destination.toString()+"\t" + "Receive Message：\t"
                    + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return tm;
    }
}
