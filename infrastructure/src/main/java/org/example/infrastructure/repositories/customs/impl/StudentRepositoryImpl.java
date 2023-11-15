package org.example.infrastructure.repositories.customs.impl;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.domain.entities.QStudent;
import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.customs.StudentRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @Override
    public List<Student> findAllStudentCustom() {
        return new JPAQuery<Student>(em)
                .select(QStudent.student)
                .from(QStudent.student)
                .fetch();
    }
}
