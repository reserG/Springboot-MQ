package com.springbootmq.controller;

import com.springbootmq.rabbitmq.MQSender;
import com.springbootmq.rabbitmq.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    MQSender mqSender;

    @ResponseBody
    @RequestMapping(value = "/testM",method = RequestMethod.POST)
    public void test(@RequestParam String user){
        System.out.println("hhhh  " + user);
    }

    @ResponseBody
    @RequestMapping(value = "/testM2",method = RequestMethod.GET)
    public void test2(@RequestParam String user){
        System.out.println("hhhh  " + user);
    }

    @ResponseBody
    @RequestMapping(value = "/sendDireMSG",method = RequestMethod.GET)
    public void sendDireMSG(@RequestParam String msg){
        mqSender.sendDirectMessage(new MyMessage(msg));
    }

    @ResponseBody
    @RequestMapping(value = "/sendTopMSG",method = RequestMethod.GET)
    public void sendTOPMSG(@RequestParam String msg){
//        for (int i=0;i<10;i++)
            mqSender.sendTopicMessage(new MyMessage(msg));
    }

    @ResponseBody
    @RequestMapping(value = "/sendFanMSG",method = RequestMethod.GET)
    public void sendFanMSG(@RequestParam String msg){
//        for (int i=0;i<10;i++)
        mqSender.sendFanoutMessage(new MyMessage(msg));
    }
}
