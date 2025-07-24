package com.pabloalbuquerque.student_hub.modules.students.repositories;

import com.pabloalbuquerque.student_hub.modules.students.entities.AnswersCertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswersCertificationRepository extends JpaRepository<AnswersCertificationEntity, UUID> {
}
