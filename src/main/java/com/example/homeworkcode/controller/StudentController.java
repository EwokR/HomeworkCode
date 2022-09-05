package com.example.homeworkcode.controller;

import com.example.homeworkcode.model.Student;
import com.example.homeworkcode.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity <Student> createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createStudent);
    }

    @GetMapping("{id}")
    public ResponseEntity <Student>  getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity <Student>  updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student.getId(), student);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Student> deleteStudent(@PathVariable Long id) {
        Student student = studentService.deleteStudent(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public Collection<Student> StudentFilter(@RequestParam int age) {
        return studentService.StudentFilter(age);
    }
}
