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
public class TopicProducerService {
    @Resource(name="jmsTemplate1")
    private JmsTemplate jmsTemplate1;
    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, final String msg) {
        for(int i=0;i<5;i++){
            System.out.println("To Topic：\t" + destination.toString() + "\t"+"Send Message------------" + msg+i);
            jmsTemplate1.send(destination, new MessageCreator() {
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
        String destination =  jmsTemplate1.getDefaultDestination().toString();
        System.out.println("To Topic ：\t" +destination+"\t"+ "Send Message------------" + msg);
        jmsTemplate1.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
