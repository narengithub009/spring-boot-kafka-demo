package com.java.demo.services;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service
public class ProducerClass {

    
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProducerClass.class);
;
    private static final String TOPIC = "user";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("************Producer Sending the message***********"+message));
        this.kafkaTemplate.send(TOPIC,message);
    }
    
}
