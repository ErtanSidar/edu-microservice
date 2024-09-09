package com.essoft.lesson_service.client;

import com.essoft.lesson_service.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface StudentClient {

    @GetExchange("/student/lesson/{lessonId}")
    public List<Student> findByLessonId(@PathVariable("lessonId") Long lessonId);
}
