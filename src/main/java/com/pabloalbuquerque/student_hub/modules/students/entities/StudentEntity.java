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
@Entity(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "studentEntity")
    private List<CertificationStudentEntity> certificationsStudentEntity;
}
