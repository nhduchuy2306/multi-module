package org.example.webapi.services;

import org.example.application.services.StudentService;
import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.StudentRepository;
import org.example.webapi.WebapiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebapiApplication.class})
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Before
    public void init() {
        studentRepository.save(new Student(UUID.randomUUID(), "name", "email", "password", "phone", "address"));
        studentRepository.save(new Student(UUID.randomUUID(), "name", "email", "password", "phone", "address"));
    }

    @Test
    public void getAllStudents() {
        var res = studentService.getAllStudents();
        assert res.size() > 0;
    }
}
