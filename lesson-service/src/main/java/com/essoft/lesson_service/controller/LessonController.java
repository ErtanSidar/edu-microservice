package com.essoft.lesson_service.controller;

import com.essoft.lesson_service.client.StudentClient;
import com.essoft.lesson_service.model.Lesson;
import com.essoft.lesson_service.producer.LessonProducer;
import com.essoft.lesson_service.repository.LessonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    LessonProducer lessonProducer;

    @PostMapping
    public Lesson add(@RequestBody Lesson lesson) {
        return lessonRepository.addLesson(lesson);
    }

    @GetMapping("/{id}")
    public Lesson findById(@PathVariable Long id) {
        return lessonRepository.findById(id);
    }

    @GetMapping
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @GetMapping("/with-students")
    public List<Lesson> findAllWithStudents() {
        List<Lesson> lessonList = lessonRepository.findAll();
        lessonList.forEach(lesson -> lesson.setStudentList(studentClient.findByLessonId(lesson.getId())));
        return lessonList;
    }

    @PostMapping("/notification")
    public ResponseEntity<Lesson> postLessonEvent(@RequestBody Lesson lesson) throws JsonProcessingException {
        lessonProducer.sendLessonTopic(lesson);
        return  ResponseEntity.status(HttpStatus.CREATED).body(lesson);
    }
}
