package org.example.infrastructure.customs.impl;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.domain.entities.QStudent;
import org.example.domain.entities.Student;
import org.example.infrastructure.customs.StudentRepositoryCustom;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StudentRepositoryImpl implements StudentRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Student findStudentByFirstName(String firstName) {
        return new JPAQuery<Student>(em)
                .select(QStudent.student)
                .from(QStudent.student)
                .where(QStudent.student.name.eq(firstName))
                .fetchOne();
    }
}
