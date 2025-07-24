package com.pabloalbuquerque.student_hub.modules.certifications.useCases;

import com.pabloalbuquerque.student_hub.modules.students.entities.CertificationStudentEntity;
import com.pabloalbuquerque.student_hub.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Top10RankingUseCase {

    @Autowired
    CertificationStudentRepository certificationStudentRepository;

    public List<CertificationStudentEntity> execute(){
        return certificationStudentRepository.findTop10ByOrderByGradeDesc();
    }
}
