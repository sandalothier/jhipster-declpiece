package com.fisc.declpiece.web.rest;

import com.fisc.declpiece.service.DeclpieceKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declpiece-kafka")
public class DeclpieceKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclpieceKafkaResource.class);

    private DeclpieceKafkaProducer kafkaProducer;

    public DeclpieceKafkaResource(DeclpieceKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
