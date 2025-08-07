package com.pabloalbuquerque.student_hub.modules.students.useCases;

import com.pabloalbuquerque.student_hub.modules.questions.repositories.QuestionRepository;
import com.pabloalbuquerque.student_hub.modules.questions.entities.AlternativeEntity;
import com.pabloalbuquerque.student_hub.modules.questions.entities.QuestionEntity;
import com.pabloalbuquerque.student_hub.modules.questions.useCases.FetchAndValidateTechnologyQuestionsUseCase;
import com.pabloalbuquerque.student_hub.modules.students.dto.StudentCertificationAnswerDTO;
import com.pabloalbuquerque.student_hub.modules.students.dto.VerifyIfHasCertificationDTO;
import com.pabloalbuquerque.student_hub.modules.certifications.entities.AnswersCertificationEntity;
import com.pabloalbuquerque.student_hub.modules.certifications.entities.CertificationStudentEntity;
import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import com.pabloalbuquerque.student_hub.modules.students.repositories.CertificationStudentRepository;
import com.pabloalbuquerque.student_hub.modules.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @Autowired
    private FetchAndValidateTechnologyQuestionsUseCase fetchAndValidateTechnologyQuestionsUseCase;

    public CertificationStudentEntity execute(StudentCertificationAnswerDTO dto) throws Exception{

        String email = dto.getEmail();
        String technology = dto.getTechnology();

        StudentEntity student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));

        if (verifyIfHasCertificationUseCase.execute(new VerifyIfHasCertificationDTO(email, technology))) {
            throw new RuntimeException("Você já tirou sua certificação!");
        }

        CertificationStudentEntity certification = fetchAndValidateTechnologyQuestionsUseCase.execute(student, dto);
        return certificationStudentRepository.save(certification);
    }
}
