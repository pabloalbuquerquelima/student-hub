package com.pabloalbuquerque.student_hub.modules.students.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answers_certification")
public class AnswersCertificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "question_id")
    private UUID questionId;

    @Column(name = "answer_id")
    private UUID answerId;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    @JsonBackReference
    private CertificationStudentEntity certificationStudentEntity;

    @Column(name = "student_id", insertable = false, updatable = false)
    private UUID studentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentEntity student;
}
