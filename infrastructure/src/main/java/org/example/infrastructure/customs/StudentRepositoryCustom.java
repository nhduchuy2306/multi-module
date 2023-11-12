package org.example.infrastructure.customs;

import org.example.domain.entities.Student;

public interface StudentRepositoryCustom {
    Student findStudentByFirstName(String firstName);
}
