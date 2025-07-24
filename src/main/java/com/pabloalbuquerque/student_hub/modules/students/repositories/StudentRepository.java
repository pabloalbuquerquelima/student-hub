package com.pabloalbuquerque.student_hub.modules.students.repositories;

import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    Optional<StudentEntity> findByEmail(String email);
}
