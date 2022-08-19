package com.dbs.service;


import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.dbs.model.Category;


@Component
@Slf4j
//@RabbitListener
public class RabbitMQReceiver {
	
	//private static final Logger log = LoggerFactory.getLogger(RabbitMQReceiver.class);

	
	private static final Logger log = LoggerFactory.getLogger(RabbitMQReceiver.class);



    @RabbitListener(queues = "${backend.rabbitmq.queue}")
    public void receivedMessage(Category category) {
        //log.info("Recieved Message From RabbitMQ: " + category);
    	log.info("Recieved Message From RabbitMQ: " + category);

    }
}