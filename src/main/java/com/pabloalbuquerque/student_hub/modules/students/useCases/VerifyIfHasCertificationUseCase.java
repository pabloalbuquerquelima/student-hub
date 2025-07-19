package com.pabloalbuquerque.student_hub.modules.useCases;

import com.pabloalbuquerque.student_hub.modules.dto.VerifyIfHasCertificationDTO;
import com.pabloalbuquerque.student_hub.modules.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;
    public boolean execute(VerifyIfHasCertificationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEntityId(dto.getEmail(), dto.getTechnology());
        return !result.isEmpty();
}
}
