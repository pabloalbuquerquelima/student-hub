package com.pabloalbuquerque.student_hub.modules.repositories;

import com.pabloalbuquerque.student_hub.modules.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
}
