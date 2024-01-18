package org.example.kafkaApplication.Consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.example.kafkaApplication.Producer.Task;
import com.fasterxml.jackson.databind.*;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerMain {
    public static void main(String[] args) {
        new ConsumerMain().runConsumer();
    }

    public void runConsumer() {
        String bootstrapServers = "localhost:9092";
        String groupId = "group1";
        String topic = "task.events";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("group.id", groupId);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, TaskDeserializer.class.getName());



        try (Consumer<String, Task> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Collections.singletonList(topic));

            while (true) {
                ConsumerRecords<String, Task> records = consumer.poll(Duration.ofMillis(100));
                records.forEach(record -> {
                    // Deserialize the JSON string to an object using Jackson
                    //String jsonString = record.value();
                    try {
                        // Replace YourClass with the actual class of your JSON objects
                        //Task deserializedObject = objectMapper.readValue(jsonString, Task.class);
                        //JsonNode jsonNode = objectMapper.readTree(jsonString);
                        //String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
                        //System.out.println("Received message: " + deserializedObject.toString());
                        //System.out.println("Received message:\n" + prettyJson);
                        Task receivedTask = record.value();
                        System.out.println("Received message: " + receivedTask);
                    } catch (Exception e) {
                        System.out.println("problem in consumermain");
                    }
                });
            }
        }
    }
}
