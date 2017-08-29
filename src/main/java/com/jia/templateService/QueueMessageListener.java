package com.jia.templateService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
public class QueueMessageListener implements MessageListener {
    //当收到消息后，自动调用该方法
    @Override
    public void onMessage(Message message) {

        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener Listened the Message：\t"
                    + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}