package com.jia.controller;

import com.jia.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jialianqing on 2017/5/9 0009.
 */
@Controller
public class Demo2Controller {

    @RequestMapping(value="/jmssend",method= RequestMethod.GET)
    public ModelAndView jmsSend() throws Exception {

        MessageSender ms = new MessageSender();
        ms.run();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Sent JMS Message!");
        mv.setViewName("jms_producer");
        return mv;
    }
    @RequestMapping(value="/jmsreceive",method= RequestMethod.GET)
    public ModelAndView jmsReceive() throws Exception {

        MessageReceiver mr = new MessageReceiver();
        mr.run();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Received JMS Message!");
        mv.setViewName("queue_receive");
        return mv;
    }
    @RequestMapping(value="/queuesend1",method= RequestMethod.GET)
    public ModelAndView queueSend() throws Exception {

        QueueSender ms = new QueueSender();
        ms.run();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Sent Queue Message!");
        mv.setViewName("jms_producer");
        return mv;
    }
    @RequestMapping(value="/queuereceive1",method= RequestMethod.GET)
    public ModelAndView queueReceive() throws Exception {

        QueueReceiver mr = new QueueReceiver();
        mr.run();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Received Queue Message!");
        mv.setViewName("queue_receive");
        return mv;
    }
    @RequestMapping(value="/topicsend1",method= RequestMethod.GET)
    public ModelAndView topicSend() throws Exception {

        TopicSender ms = new TopicSender();
        ms.run();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Sent Topic Message!");
        mv.setViewName("jms_producer");
        return mv;
    }
    @RequestMapping(value="/topicreceive1",method= RequestMethod.GET)
    public ModelAndView topicReceive() throws Exception {

        TopicReceiver mr = new TopicReceiver();
        mr.run();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Received Topic Message!");
        mv.setViewName("queue_receive");
        return mv;
    }
    @RequestMapping(value="/client",method= RequestMethod.GET)
    public ModelAndView client() throws Exception {

        new Client();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Sent Message!");
        mv.setViewName("jms_producer");
        return mv;
    }
    @RequestMapping(value="/server",method= RequestMethod.GET)
    public ModelAndView server() throws Exception {
        new Server();
        ModelAndView mv = new ModelAndView();
        mv.addObject("textMessage", "Received Message!");
        mv.setViewName("queue_receive");
        return mv;
    }
}
