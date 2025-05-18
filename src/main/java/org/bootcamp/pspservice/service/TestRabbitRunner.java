package org.bootcamp.pspservice.service;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class TestRabbitRunner implements CommandLineRunner {

@Autowired
private AmqpAdmin amqpAdmin;

@Override
public void run(String... args) {
    Properties props = amqpAdmin.getQueueProperties("shaparak.queue");
    if (props != null) {
        System.out.println("Queue shaparak.queue exists.");
        System.out.println("Message count: " + props.get("QUEUE_MESSAGE_COUNT"));
    } else {
        System.out.println("Queue shaparak.queue does NOT exist.");
    }
}
}

