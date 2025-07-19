package com.pabloalbuquerque.student_hub.modules.controllers;

import com.pabloalbuquerque.student_hub.modules.dto.VerifyIfHasCertificationDTO;
import com.pabloalbuquerque.student_hub.modules.useCases.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO verifyIfHasCertificationDTO) {
        boolean result = verifyIfHasCertificationUseCase.execute(verifyIfHasCertificationDTO);
        return result ? "Usuário já fez a prova" : "Usuário ainda não fez a prova";
    }
}
