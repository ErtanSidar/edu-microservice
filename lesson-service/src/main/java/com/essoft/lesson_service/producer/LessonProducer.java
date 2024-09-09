package com.essoft.lesson_service.producer;

import com.essoft.lesson_service.model.Lesson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class LessonProducer {

    @Autowired
    KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void sendLessonTopic(Lesson lesson) throws JsonProcessingException {
        Long id = lesson.getId();
        String value = objectMapper.writeValueAsString(lesson);
        CompletableFuture<SendResult<Long, String>> completableFuture = kafkaTemplate.sendDefault(id, value);
        completableFuture.thenApply(result -> {
            handleSuccess(id, value, result);
            return null;
        });
        completableFuture.exceptionally(throwable -> {
            handleFailure(throwable);
            return null;
        });
    }

    private void handleFailure(Throwable throwable) {
        System.out.println("When message sent, an error occurred: " + throwable.getMessage());
        try {
            throw throwable;
        } catch (Throwable e) {
            System.err.println("Error in OnFailure: " + e.getMessage());
        }
    }

    private void handleSuccess(Long id, String value, SendResult<Long, String> result) {
        System.out.println("Message sent, Key: " + id + "Value : " + value + "partition: " + result.getRecordMetadata().partition());
    }
}
