package org.example.infrastructure.repositories;

import org.example.domain.entities.Student;
import org.example.infrastructure.repositories.customs.StudentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>, StudentRepositoryCustom {
    Optional<Student> findByName(String name);
}
