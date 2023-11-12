package org.example.infrastructure.repositories;

import org.example.domain.entities.Student;
import org.example.infrastructure.customs.StudentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>, QuerydslPredicateExecutor<Student>, StudentRepositoryCustom {
}
