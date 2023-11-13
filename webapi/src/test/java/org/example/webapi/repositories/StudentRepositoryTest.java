package org.example.webapi.repositories;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.domain.entities.QStudent;
import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.StudentRepository;
import org.example.webapi.WebapiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.UUID;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WebapiApplication.class})
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager em;

    private Logger logger = Logger.getLogger(StudentRepositoryTest.class.getName());

    @Before
    public void setUp() {
        studentRepository.save(new Student(UUID.randomUUID(), "name1", "email1", "password1", "phone1", "address1"));
        studentRepository.save(new Student(UUID.randomUUID(), "name2", "email2", "password2", "phone2", "address2"));
    }

    @Test
    public void testGetAllStudents() {
        var res = studentRepository.findAll();
        logger.info("---------------------------------------Result:" +  res);
        assert res.size() > 0;
    }

    @Test
    public void testGetStudentByName(){
        String name = "name1";
        var res = studentRepository.findByName(name);
        assert res.isPresent();
    }

    @Test
    public void testSaveStudent(){
        UUID id = UUID.randomUUID();
        Student student = new Student(id, "name3", "email3", "password3", "phone3", "address3");
        studentRepository.save(student);

        var findRes = new JPAQuery<>(em)
                .from(QStudent.student)
                .where(QStudent.student.name.eq("name3"))
                .fetchFirst();

        assert findRes != null;
    }
}
