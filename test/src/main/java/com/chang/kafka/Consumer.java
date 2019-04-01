package com.chang.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    private static final Properties properties = new Properties();
    public final static String TOPIC = "test";
    KafkaConsumer<String, String> kafkaConsumer = null;

    public Consumer() {
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        properties.put("group.id", "group-1");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Arrays.asList(TOPIC));
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.kafkaConsumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("topic = %s, partition = %s, offset = %d, key = %s, value = %s",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    System.out.println();
                }
            }
        } finally {
            consumer.kafkaConsumer.close();
        }

    }
}
