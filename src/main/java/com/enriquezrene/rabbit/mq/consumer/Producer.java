package com.enriquezrene.rabbit.mq.consumer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rene on 31/10/16.
 */
@RestController
@RequestMapping("/producer")
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        rabbitTemplate.convertAndSend(RabbitMqApplication.QUEUE_NAME, message);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
