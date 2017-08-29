package com.jia.controller;

import com.jia.templateService.QueueConsumerService;
import com.jia.templateService.QueueProducerService;
import com.jia.templateService.TopicConsumerService;
import com.jia.templateService.TopicProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jialianqing on 2017/5/9 0009.
 */
@Controller
public class DemoController {

    //QueueName
    @Resource(name="demoQueueDestination")
    private Destination demoQueueDestination;

    //QueueMessageProducer
    @Resource(name="queueProducerService")
    private QueueProducerService queueProducer;

    //QueueMessageConsumer
    @Resource(name="queueConsumerService")
    private QueueConsumerService queueConsumer;

    //TopicName
    @Resource(name="demoTopicDestination")
    private Destination demoTopicDestination;

    //QueueMessageProducer
    @Resource(name="topicProducerService")
    private TopicProducerService topicProducer;

    //QueueMessageConsumer
    @Resource(name="topicConsumerService")
    private TopicConsumerService topicConsumer;
    @RequestMapping(value="/onsend",method=RequestMethod.GET)
    public ModelAndView send(@RequestParam("type") String type) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = dateFormat.format( now );
        System.out.println("------------send to jms");
        ModelAndView mv = new ModelAndView();
        if(type.equals("queue")) {
            queueProducer.sendMessage(demoQueueDestination, message);
        }else{
            topicProducer.sendMessage(demoTopicDestination, message);
        }
        mv.addObject("textMessage", "Sent Message!");
        mv.setViewName("jms_producer");
        return mv;
    }

    @RequestMapping(value="/queuereceive",method=RequestMethod.GET)
    public ModelAndView queue_receive() throws JMSException {
        System.out.println("------------receive message");
        ModelAndView mv = new ModelAndView();

        TextMessage tm = queueConsumer.receive(demoQueueDestination);
        mv.addObject("textMessage", tm.getText());

        mv.setViewName("queue_receive");
        return mv;
    }

    @RequestMapping(value="/topicreceive",method=RequestMethod.GET)
    public ModelAndView topic_receive() throws JMSException {
        System.out.println("------------receive message");
        ModelAndView mv = new ModelAndView();

        TextMessage tm = topicConsumer.receive(demoTopicDestination);
        mv.addObject("textMessage", tm.getText());

        mv.setViewName("queue_receive");
        return mv;
    }
    /*
     * ActiveMQ Manager Test
     */
    @RequestMapping(value="/jms",method=RequestMethod.GET)
    public ModelAndView jmsManager() throws IOException {
        System.out.println("------------jms manager");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.jsp");
        JMXServiceURL url = new JMXServiceURL("");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        connector.connect();
        MBeanServerConnection connection = connector.getMBeanServerConnection();
        return mv;
    }
}
