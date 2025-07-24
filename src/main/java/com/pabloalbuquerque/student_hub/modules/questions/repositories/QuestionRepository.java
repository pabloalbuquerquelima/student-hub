package com.pabloalbuquerque.student_hub.modules.questions.repositories;

import com.pabloalbuquerque.student_hub.modules.questions.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID> {
    List<QuestionEntity> findByTechnology(String technology);
}
