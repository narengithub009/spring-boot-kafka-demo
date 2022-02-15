package com.java.demo.controller;

import com.java.demo.services.ProducerClass;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {
	
    private final ProducerClass producer;
  
    public KafkaController(ProducerClass producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String sendMessage(@RequestParam("message") String message){
    	long count=0;
    	for(int i=0;i<=1000;i++) {
        this.producer.sendMessage(message);
        count++;
    	}
    	//System.out.println(count);
        return  "Message Sent Successfully"+count;
    }
    @Bean
    public NewTopic adviceTopic(){
        return new NewTopic("user",3, (short) 1);
    }
}
