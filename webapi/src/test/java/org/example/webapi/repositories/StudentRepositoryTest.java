package org.example.webapi.repositories;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.domain.entities.QStudent;
import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.StudentRepository;
import org.example.webapi.WebapiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.UUID;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebapiApplication.class})
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager em;

    private final Logger LOG = LoggerFactory.getLogger(StudentRepositoryTest.class);

    @Before
    public void setUp() {
        studentRepository.save(new Student(UUID.randomUUID(), "name1", "email1", "password1", "phone1", "address1"));
        studentRepository.save(new Student(UUID.randomUUID(), "name2", "email2", "password2", "phone2", "address2"));
    }

    @Test
    public void testSaveStudent() {
        UUID id = UUID.randomUUID();
        Student student = new Student(id, "name3", "email3", "password3", "phone3", "address3");
        studentRepository.save(student);

        var findRes = new JPAQuery<>(em)
                .from(QStudent.student)
                .where(QStudent.student.name.eq("name3"))
                .fetchFirst();

        assert findRes != null;
    }

    @Test
    public void testGetAllStudents() {
        var res = studentRepository.findAll();
        LOG.debug("Response : {}", res);
        assert res.size() > 0;
    }

    @Test
    public void testGetStudentByName() {
        final String NAME = "name4";
        Student res = new JPAQuery<Student>(em)
                .from(QStudent.student)
                .where(QStudent.student.name.eq(NAME))
                .fetchFirst();
        assert res != null;
    }
}
