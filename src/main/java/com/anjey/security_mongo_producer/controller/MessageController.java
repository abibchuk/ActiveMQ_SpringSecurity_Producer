package com.anjey.security_mongo_producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Anjey on 21.12.2017.
 */

@Controller
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(com.anjey.security_mongo_producer.controller.UserController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "/send_form", method = RequestMethod.GET)
    public String sentPage() {
        return "send_form";
    }

    @RequestMapping(value = "/send_form", method = RequestMethod.POST)
    public String createMessage(@RequestParam("message") String message) {
        try {

//            jmsTemplate.send(new MessageCreator(){
//                public Message createMessage(Session session) throws JMSException{
//                    TextMessage textMessage = session.createTextMessage(message);
//                    return textMessage;
//                }
//            });

            jmsTemplate.send(session -> session.createTextMessage(message));

            return "success";
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
            return "failure";
        }
    }

}
