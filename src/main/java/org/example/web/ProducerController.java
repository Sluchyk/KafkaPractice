package org.example.web;
import org.example.Constants;
import org.example.config.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/index")
public class ProducerController {

    private   KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        String topicName = Constants.TOPIC_NAME;
        kafkaProducer.sendMessage(message, topicName);
        return ResponseEntity.ok("Message sent to kafka topic " + topicName);
    }
}