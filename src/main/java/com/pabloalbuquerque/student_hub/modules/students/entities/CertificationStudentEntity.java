package com.pabloalbuquerque.student_hub.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Entity(name = "certifications")
public class CertificationStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonManagedReference
    private UUID id;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grade;

    @Column(name = "student_id", insertable = false, updatable = false)
    private UUID studentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentEntity student;

    @OneToMany(mappedBy = "certificationStudentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AnswersCertificationEntity> answersCertificationEntities;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
