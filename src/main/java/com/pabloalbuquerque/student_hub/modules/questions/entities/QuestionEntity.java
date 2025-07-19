package com.pabloalbuquerque.student_hub.questions.entities;

import com.pabloalbuquerque.student_hub.entities.CertificationStudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column(unique = true, nullable = false, length = 50)
    private String technology;

    @Column(unique = true, nullable = false)
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn( name = "question_id" )
    private List<AlternativeEntity> alternatives;
}
