package com.course.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSchemaConfig {
  @Bean
  public Declarables rabbitMQSchema() {
    return new Declarables(
        new FanoutExchange("x.code-created-fanout-exchange", true, false),
        new Queue("q.code-created-createQueue"),
        new Binding(
            "q.code-created-createQueue",
            Binding.DestinationType.QUEUE,
            "x.code-created-fanout-exchange",
            "",
            null));
  }
}
