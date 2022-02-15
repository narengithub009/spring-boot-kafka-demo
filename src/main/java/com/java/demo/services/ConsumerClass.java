package com.java.demo.services;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class ConsumerClass {
    
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ConsumerClass.class);


    @KafkaListener(topics = "user")
    public void consume(String message){
        log.info(String.format("************Consumer just received the message*********** "+message));
    }
}
