package com.pabloalbuquerque.student_hub.modules.questions.dto;

import com.pabloalbuquerque.student_hub.modules.questions.entities.AlternativeEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface QuestionAlternativeResult {

    @Id
    private UUID id;

    private String technology;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn( name = "question_id" )
    private List<AlternativeEntity> alternatives;
}
