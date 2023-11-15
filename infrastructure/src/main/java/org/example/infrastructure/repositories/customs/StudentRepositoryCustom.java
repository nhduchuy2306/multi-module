package org.example.infrastructure.repositories.customs;

import org.example.domain.entities.Student;

import java.util.List;

public interface StudentRepositoryCustom {
    Student findStudentByFirstName(String firstName);
    List<Student> findAllStudentCustom();
}
