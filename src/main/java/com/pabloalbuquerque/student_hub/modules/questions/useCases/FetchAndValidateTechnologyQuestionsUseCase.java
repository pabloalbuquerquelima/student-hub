package com.pabloalbuquerque.student_hub.modules.questions.useCases;

import com.pabloalbuquerque.student_hub.modules.certifications.entities.AnswersCertificationEntity;
import com.pabloalbuquerque.student_hub.modules.certifications.entities.CertificationStudentEntity;
import com.pabloalbuquerque.student_hub.modules.questions.entities.AlternativeEntity;
import com.pabloalbuquerque.student_hub.modules.questions.entities.QuestionEntity;
import com.pabloalbuquerque.student_hub.modules.questions.repositories.QuestionRepository;
import com.pabloalbuquerque.student_hub.modules.students.dto.StudentCertificationAnswerDTO;
import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FetchAndValidateTechnologyQuestionsUseCase {

    @Autowired
    private QuestionRepository questionRepository;

    public CertificationStudentEntity execute(StudentEntity student, StudentCertificationAnswerDTO dto) throws Exception {
        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());
        List<AnswersCertificationEntity> answersCertification = new ArrayList<>();
        AtomicInteger correctAnswer = new AtomicInteger(0);

        dto.getQuestionAnswer().forEach(questionAnswer -> {
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

            if (isCorrect) {
                correctAnswer.incrementAndGet();
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
                    .technology(dto.getTechnology())
                    .studentId(student.getId())
                    .grade(correctAnswer.get())
                    .build();

            answersCertification.forEach(answer -> answer.setCertificationStudentEntity(certification));
            certification.setAnswersCertificationEntities(answersCertification);

            return certification;
    }
}
