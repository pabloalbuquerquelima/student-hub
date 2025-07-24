package com.pabloalbuquerque.student_hub.modules.students.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<CertificationStudentEntity> certificationsStudentEntity;
}
