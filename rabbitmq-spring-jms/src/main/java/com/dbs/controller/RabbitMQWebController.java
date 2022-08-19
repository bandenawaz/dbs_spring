package com.dbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.model.Category;
import com.dbs.service.RabbitMQSender;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/rabbitmq")
@Slf4j
public class RabbitMQWebController {

	private static final Logger log = LoggerFactory.getLogger(RabbitMQWebController.class);

	@Autowired
	private AmqpTemplate rabbitTemplateBean;

	@Autowired
	private RabbitMQSender rabbitMQSender;

	// direct
	// http://localhost:8080/api/rabbitmq/producre?code=001&description=MyDescription
	@GetMapping(value = "/producer")
	public String producer(@ModelAttribute Category category) {

		log.info(" category {}  {} ", category.getCode(), category.getDescription());
		return "Message sent to the RabbitMQ Successfully";
	}

	// http://localhost:8080/api/rabbitmq/topic?exchangeName=topic-exchange&routingKey=queue.admin&messageData=MessageData
	@GetMapping(value = "/exchange")
	public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
			@RequestParam("messageData") String messageData) {

		rabbitTemplateBean.convertAndSend(exchange, routingKey, messageData);

		return "Message sent to the RabbitMQ Successfully";
	}

	// http://localhost:8080/api/rabbitmq/fanout?exchangeName=fanout-exchange&messageData=message
	@GetMapping(value = "/fanout")
	public String fanout(@RequestParam("exchangeName") String exchange,
			@RequestParam("messageData") String messageData) {

		log.info("send to mq {} {}", exchange, messageData);
		rabbitTemplateBean.convertAndSend(exchange, "", messageData);

		return "Message sent to the RabbitMQ Successfully";
	}

	// http://localhost:8080/api/rabbitmq/topic?exchangeName=topic-exchange&routingKey=queue.admin&messageData=MessageData
	@GetMapping(value = "/topic")
	public String producerTopic(@RequestParam("exchangeName") String exchange,
			@RequestParam("routingKey") String routingKey, @RequestParam("messageData") String messageData) {

		log.info("send to mq with topic type{} {}", exchange, messageData);
		rabbitTemplateBean.convertAndSend(exchange, routingKey, messageData);
		return "Message sent to the RabbitMQ Topic Exchange Successfully";
	}

	// http://localhost:8080/api/rabbitmq/header?exchangeName=header-exchange&department=admin&messageData=MessageValue
	@GetMapping(value = "/header")
	public String producerHeader(@RequestParam("exchangeName") String exchange,
			@RequestParam("department") String department, @RequestParam("messageData") String messageData) {

		final MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("department", department);
		MessageConverter messageConverter = new SimpleMessageConverter();
		Message message = messageConverter.toMessage(messageData, messageProperties);
		rabbitTemplateBean.send(exchange, "", message);

		return "Message sent to the RabbitMQ Header Exchange Successfully";
	}
}