package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Producer producer;

    @Autowired
    public TestController(Producer producer) {
        this.producer = producer;
    }
    @RequestMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message){

        this.producer.sendMessage(message);
        System.out.println("From controller recieved the message : "+ message);


    }
}
