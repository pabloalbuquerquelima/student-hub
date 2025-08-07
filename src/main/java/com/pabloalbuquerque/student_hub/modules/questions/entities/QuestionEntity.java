package com.pabloalbuquerque.student_hub.modules.questions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String technology;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotBlank
    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotBlank
    @OneToMany
    @JoinColumn( name = "question_id" )
    private List<AlternativeEntity> alternatives;
}
