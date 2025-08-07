package com.pabloalbuquerque.student_hub.modules.certifications.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answers_certification")
public class AnswersCertificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "question_id")
    private UUID questionId;

    @NotBlank
    @Column(name = "answer_id")
    private UUID answerId;

    @NotBlank
    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    @JsonBackReference
    private CertificationStudentEntity certificationStudentEntity;

    @NotBlank
    @Column(name = "student_id", insertable = false, updatable = false)
    private UUID studentId;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentEntity student;
}
