package com.jia.templateService;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by jialianqing on 2017/5/9 0009.
 */

@Service
public class QueueProducerService {
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, final String msg) {
        for(int i=0;i<5;i++){
            System.out.println("To Queue：\t" + destination.toString() + "\t"+"Send Message------------" + msg+i);
            jmsTemplate.send(destination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });
        }
    }
    /**
     * 向默认队列发送消息
     */
    public void sendMessage(final String msg) {
        String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("To Queue ：\t" +destination+"\t"+ "Send Message------------" + msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });

    }

}
