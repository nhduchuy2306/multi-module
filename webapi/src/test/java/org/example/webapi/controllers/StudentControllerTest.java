package org.example.webapi.controllers;

import org.example.application.services.StudentService;
import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.StudentRepository;
import org.example.infrastructure.repositories.customs.impl.StudentRepositoryImpl;
import org.example.webapi.WebapiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {WebapiApplication.class})
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private StudentRepositoryImpl studentRepositoryImpl;

    @Test
    public void testControllerGetAllStudents() throws Exception {
        List<Student> students = List.of(
                new Student("name1", "email1", "password1", "phone1", "address1"),
                new Student("name2", "email2", "password2", "phone2", "address2")
        );
        when(studentService.getAllStudents()).thenReturn(students);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/students").accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

        assert resultActions.andReturn().getResponse().getContentAsString().contains("name1");
    }
}
