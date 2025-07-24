package com.pabloalbuquerque.student_hub.modules.students.useCases;

import com.pabloalbuquerque.student_hub.modules.students.dto.VerifyIfHasCertificationDTO;
import com.pabloalbuquerque.student_hub.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyIfHasCertificationDTO dto) {
        var result = certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if (!result.isEmpty()) {
            return true;
        };
        return false;
}
}
