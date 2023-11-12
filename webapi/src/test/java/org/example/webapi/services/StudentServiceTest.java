package org.example.webapi.services;

import org.example.application.services.StudentService;
import org.example.webapi.AppConfig;
import org.example.webapi.WebapiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes ={ StudentServiceTest.TestConfig.class, WebapiApplication.class})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getAllStudents() {
        var res = studentService.getAllStudents();

        assert res.size() > 0;
    }

    @EnableConfigurationProperties(AppConfig.class)
    public class TestConfig {
    }
}
