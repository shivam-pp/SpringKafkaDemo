package com.example.kafkaproducerGRCP.PartitionerLogic;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomPartitioner implements Partitioner {

    @Override
    public void configure(Map<String, ?> configs) {
        // No configuration needed
    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String keyStr = (String) key;

        if (keyStr.startsWith("5")) {
            return 0; 
        } else if (keyStr.startsWith("4")) {
            return 1; 
        } else {
            return 2; 
        }
    }

    @Override
    public void close() {
    }
}

