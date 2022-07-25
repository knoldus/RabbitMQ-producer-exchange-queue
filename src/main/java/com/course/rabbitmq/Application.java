package com.course.rabbitmq;

import com.course.rabbitmq.entity.DummyMessage;
import com.course.rabbitmq.producer.DummyMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private DummyMessageProducer dummyMessageProducer;

	@Override
	public void run(String... args) throws Exception {
		DummyMessage dummyMessage = new DummyMessage("Now Time is : " + LocalTime.now(), 10);
		dummyMessageProducer.sendMessage(dummyMessage);
	}
}
