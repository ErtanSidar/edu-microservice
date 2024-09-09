package com.essoft.student_service.repository;

import com.essoft.student_service.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public List<Student> studentList = new ArrayList<>();

    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }

    public Student findById(Long id) {
        return studentList.stream().filter(s -> s.id().equals(id)).findFirst().orElse(null);
    }

    public List<Student> findAll() {
        return studentList;
    }

    public List<Student> findByLessonId(Long lessonId) {
        return studentList.stream().filter(s -> s.lessonId().equals(lessonId)).toList();
    }
}
