package com.pabloalbuquerque.student_hub.modules.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "answers_certification" )
public class AnswersCertificationEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column( name = "question_id" )
    private UUID questionId;

    @Column( name = "answer_id" )
    private UUID answerId;

    @Column( name = "is_correct" )
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn( name = "answers_certification_id", insertable = false, updatable = false )
    private CertificationStudentEntity certificationStudentEntity;

    @ManyToOne
    @JoinColumn( name = "student_id", insertable = false, updatable = false )
    private StudentEntity studentEntity;
}
