package com.pabloalbuquerque.student_hub.modules.students.controllers;

import com.pabloalbuquerque.student_hub.modules.students.dto.StudentCertificationAnswerDTO;
import com.pabloalbuquerque.student_hub.modules.students.dto.StudentEntityDTO;
import com.pabloalbuquerque.student_hub.modules.students.dto.VerifyIfHasCertificationDTO;
import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import com.pabloalbuquerque.student_hub.modules.students.useCases.CreateStudentUseCase;
import com.pabloalbuquerque.student_hub.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.pabloalbuquerque.student_hub.modules.students.useCases.VerifyIfHasCertificationUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @Autowired
    private CreateStudentUseCase createStudentUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentEntity student) {
        try{
            StudentEntityDTO result = createStudentUseCase.execute(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@Valid @RequestBody VerifyIfHasCertificationDTO verifyIfHasCertificationDTO) {
        boolean result = verifyIfHasCertificationUseCase.execute(verifyIfHasCertificationDTO);
        return result ? "Usuário já fez a prova" : "Usuário ainda não fez a prova";
    }

    @PostMapping("/certification/answers")
    public ResponseEntity<Object> certificationAnswers(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try{
        var result = studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
        return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    };
}
