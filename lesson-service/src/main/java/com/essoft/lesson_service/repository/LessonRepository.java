package com.essoft.lesson_service.repository;

import com.essoft.lesson_service.model.Lesson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonRepository {

    public List<Lesson> lessonList = new ArrayList<>();

    public Lesson addLesson(Lesson lesson) {
        lessonList.add(lesson);
        return lesson;
    }

    public Lesson findById(Long id) {
        return lessonList.stream().filter(lesson -> lesson.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Lesson> findAll() {
        return lessonList;
    }
}
