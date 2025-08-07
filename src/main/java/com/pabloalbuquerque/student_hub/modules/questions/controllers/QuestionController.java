package com.pabloalbuquerque.student_hub.modules.questions.controllers;

import com.pabloalbuquerque.student_hub.modules.questions.repositories.QuestionRepository;
import com.pabloalbuquerque.student_hub.modules.questions.dto.AlternativesResultDTO;
import com.pabloalbuquerque.student_hub.modules.questions.dto.QuestionResultDTO;
import com.pabloalbuquerque.student_hub.modules.questions.entities.AlternativeEntity;
import com.pabloalbuquerque.student_hub.modules.questions.entities.QuestionEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@Valid @PathVariable String technology) {
        var result = questionRepository.findByTechnology(technology);

        return result.stream().map(QuestionController::mapQuestionDTO)
                .toList();
    }

    static QuestionResultDTO mapQuestionDTO (QuestionEntity question) {
        var questionResultDTO = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription()).build();

        List<AlternativesResultDTO> alternativesResultDTOS = question.getAlternatives()
                .stream().map(QuestionController::mapAlternativeDTO)
                .toList();

        questionResultDTO.setAlternatives(alternativesResultDTOS);
        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativeDTO (AlternativeEntity alternative) {
        return AlternativesResultDTO.builder()
                .id(alternative.getId())
                .description(alternative.getDescription()).build();

    }
}
