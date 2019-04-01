package com.chang.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {
    private final KafkaProducer<String, String> producer;
    public final static String TOPIC = "test";

    private Producer() {
        Properties props = new Properties();
        //此处配置的是kafka的端口
        props.put("bootstrap.servers", "127.0.0.1:9092");

        //配置key value的序列化类
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<String, String>(props);
    }

    public void produce() {
        for (int i = 30; i < 40; i++) {
            String key = String.valueOf(i);
            String data = "hello kafka message：" + key;
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, key, data);
            try {
                send(record);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(data);
        }
        producer.close();
    }

    // 简单发送
    private void send(ProducerRecord<String, String> record) {
        producer.send(record);
    }

    //同步发送
    private void sendSync(ProducerRecord<String, String> record)
            throws ExecutionException, InterruptedException {
        producer.send(record).get();
    }

    //异步发送
    private void sendASync(ProducerRecord<String, String> record)
            throws ExecutionException, InterruptedException {
        producer.send(record, new ProcucerCallback());
    }

    public static void main(String[] args) {
        new Producer().produce();
    }

    private class ProcucerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (null != e) {
                e.printStackTrace();
            }
        }
    }
}
