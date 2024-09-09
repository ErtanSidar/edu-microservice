package com.essoft.lesson_service.model;

public record Student(
        Long id,
        String name,
        Long lessonId
) {
}
