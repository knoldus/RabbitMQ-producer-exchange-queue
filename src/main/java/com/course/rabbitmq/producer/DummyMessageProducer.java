package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DummyMessage dummyMessage) {
        rabbitTemplate.convertAndSend("x.code-created-fanout-exchange","",dummyMessage);
    }
}
