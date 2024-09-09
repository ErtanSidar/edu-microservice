package com.essoft.student_service.model;

public record Student(
        Long id,
        String name,
        Long lessonId
) {
}
