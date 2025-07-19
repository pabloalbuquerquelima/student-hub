package com.pabloalbuquerque.student_hub.modules.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications")
public class CertificationStudentEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grade;

    @ManyToOne
    @JoinColumn( name = "student_id", insertable = false, updatable = false )
    private StudentEntity studentEntity;

    @OneToMany( mappedBy = "certificationStudentEntity" )
    private List<AnswersCertificationEntity> answersCertificationEntity;

}
