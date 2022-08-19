package com.dbs.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dbs.model.Category;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class RabbitMQSender {
	
	
	private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${backend.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${backend.rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Category category) {
		
		rabbitTemplate.convertAndSend(exchange, routingKey, category);
		//log.info("Send msf = {} ",category);
		log.info("Send msf = {} ",category);

	}

}
