package com.example.kafkaproducerGRCP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/{topic}")
    public String publishMessage(@PathVariable String topic, @RequestBody Map<String, Object> payload) {
        String key = (String) payload.get("id");
        String value = payload.toString();
        kafkaTemplate.send(topic, key, value);
        return "Message published successfully to topic: " + topic;
    }
}

