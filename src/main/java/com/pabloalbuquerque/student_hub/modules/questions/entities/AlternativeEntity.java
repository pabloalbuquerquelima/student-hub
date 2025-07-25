package com.pabloalbuquerque.student_hub.modules.questions.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "alternatives")
public class AlternativeEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    private String description;

    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
