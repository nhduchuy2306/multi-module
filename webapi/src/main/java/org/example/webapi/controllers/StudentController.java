package org.example.webapi.controllers;

import org.example.application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllStudents() {
        System.out.println(studentService);
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/custom")
    public ResponseEntity<?> getAllStudentsCustom() {
        return ResponseEntity.ok(studentService.getAllStudentsCustom());
    }
}
