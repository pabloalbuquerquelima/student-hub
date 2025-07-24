package com.pabloalbuquerque.student_hub.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyIfHasCertificationDTO {
    private String email;
    private String technology;
}
