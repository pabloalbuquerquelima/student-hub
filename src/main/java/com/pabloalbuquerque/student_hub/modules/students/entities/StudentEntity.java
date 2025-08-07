package com.pabloalbuquerque.student_hub.modules.students.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pabloalbuquerque.student_hub.modules.certifications.entities.CertificationStudentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Length(min = 6)
    @Pattern(regexp = "\\S+$", message = "O campo não pode conter espaços")
    @Column(nullable = false)
    private String slug;

    @NotBlank
    @Length(min = 3)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email(message = "O campo deve ser um email válido")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Length(min = 6)
    private String password;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("student")
    private List<CertificationStudentEntity> certificationsStudentEntity;
}
