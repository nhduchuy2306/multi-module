package org.example.webapi.services;

import org.example.application.services.StudentService;
import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.StudentRepository;
import org.example.webapi.WebapiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebapiApplication.class})
public class StudentServiceTest {

    @MockBean
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() {
        final List<Student> students = new ArrayList<>(List.of(
                new Student(UUID.randomUUID(), "name1", "email1", "password1", "phone1", "address1"),
                new Student(UUID.randomUUID(), "name2", "email2", "password2", "phone2", "address2"))
        );
        when(studentRepository.findAll()).thenReturn(students);
    }

    @Test
    public void getAllStudents() {
        var res = studentService.getAllStudents();
        assert res.size() > 0;
    }
}
