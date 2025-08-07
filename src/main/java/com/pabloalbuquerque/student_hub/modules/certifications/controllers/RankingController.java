package com.pabloalbuquerque.student_hub.modules.certifications.controllers;

import com.pabloalbuquerque.student_hub.modules.certifications.useCases.Top10RankingUseCase;
import com.pabloalbuquerque.student_hub.modules.certifications.entities.CertificationStudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    Top10RankingUseCase top10RankingUseCase;

    @GetMapping("/top10")
    public List<CertificationStudentEntity> topRanking(){
        return top10RankingUseCase.execute();
    }
}
