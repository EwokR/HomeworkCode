package com.example.homeworkcode.service;

import com.example.homeworkcode.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long generatedStudentId = 1L;


    public Student createStudent(Student student) {
        student.setId(generatedStudentId);
        students.put(generatedStudentId, student);
        generatedStudentId++;
        return student;
    }

    public Student getStudentById(Long id) {
        return students.get(id);
    }

    public Student updateStudent(Long id, Student student) {
        students.put(id, student);
        return student;
    }

    public Student deleteStudent(Long id) {
        Student student = students.get(id);
        students.remove(id);
        return student;
    }

    public Collection<Student> StudentFilter(Integer age) {
        return students.values().stream()
                .filter(e -> age.equals(e.getAge()))
                .collect(Collectors.toList());
    }
}
