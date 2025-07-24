package com.pabloalbuquerque.student_hub.modules.students.useCases;

import com.pabloalbuquerque.student_hub.modules.questions.repositories.QuestionRepository;
import com.pabloalbuquerque.student_hub.modules.questions.entities.AlternativeEntity;
import com.pabloalbuquerque.student_hub.modules.questions.entities.QuestionEntity;
import com.pabloalbuquerque.student_hub.modules.students.dto.StudentCertificationAnswerDTO;
import com.pabloalbuquerque.student_hub.modules.students.dto.VerifyIfHasCertificationDTO;
import com.pabloalbuquerque.student_hub.modules.students.entities.AnswersCertificationEntity;
import com.pabloalbuquerque.student_hub.modules.students.entities.CertificationStudentEntity;
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
    QuestionRepository questionRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    public CertificationStudentEntity execute(StudentCertificationAnswerDTO studentCertificationAnswerDTO) throws Exception{

        var verifyIfHasCertification = verifyIfHasCertificationUseCase.execute(new VerifyIfHasCertificationDTO(studentCertificationAnswerDTO.getEmail(), studentCertificationAnswerDTO.getTechnology()));

        if (verifyIfHasCertification){
            throw new Exception("Você ja tirou sua certificação!");
        }
        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(studentCertificationAnswerDTO.getTechnology());
        List<AnswersCertificationEntity> answersCertification = new ArrayList<>();
        AtomicInteger correctAnswer = new AtomicInteger(0);

        var student = studentRepository.findByEmail(studentCertificationAnswerDTO.getEmail())
                .orElseGet(() -> studentRepository.save(StudentEntity.builder()
                        .email(studentCertificationAnswerDTO.getEmail())
                        .build()));

        studentCertificationAnswerDTO.getQuestionAnswer().forEach(questionAnswer -> {
            var question = questionsEntity.stream()
                    .filter(q -> q.getId().equals(questionAnswer.getQuestionId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Questão não encontrada: " + questionAnswer.getQuestionId()));

            var correctAlternative = question.getAlternatives().stream()
                    .filter(AlternativeEntity::isCorrect)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Alternativa correta não encontrada para a questão: " + question.getId()));

            boolean isCorrect = correctAlternative.getId().equals(questionAnswer.getAlternativeId());
            questionAnswer.setCorrect(isCorrect);

            if (correctAlternative.getId().equals(questionAnswer.getAlternativeId())) {
                questionAnswer.setCorrect(true);
                correctAnswer.incrementAndGet();

            } else {
                questionAnswer.setCorrect(false);
            }

            AnswersCertificationEntity answerEntity = AnswersCertificationEntity.builder()
                    .questionId(questionAnswer.getQuestionId())
                    .answerId(questionAnswer.getAlternativeId())
                    .isCorrect(isCorrect)
                    .studentId(student.getId())
                    .build();

            answersCertification.add(answerEntity);
        });

        CertificationStudentEntity certification = CertificationStudentEntity.builder()
                .technology(studentCertificationAnswerDTO.getTechnology())
                .studentId(student.getId())
                .grade(correctAnswer.get())
                .build();

        answersCertification.forEach(answer -> answer.setCertificationStudentEntity(certification));
        certification.setAnswersCertificationEntities(answersCertification);

        return certificationStudentRepository.save(certification);
    }
}
