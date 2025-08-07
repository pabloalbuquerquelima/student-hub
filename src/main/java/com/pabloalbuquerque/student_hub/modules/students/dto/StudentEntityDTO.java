package com.pabloalbuquerque.student_hub.modules.students.dto;

import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntityDTO {

    @NotBlank
    @Length(min = 3)
    private String name;

    @NotBlank
    @Length(min = 6)
    private String slug;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 6)
    private String password;
}
