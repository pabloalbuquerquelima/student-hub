package com.pabloalbuquerque.student_hub.modules.students.useCases;

import com.pabloalbuquerque.student_hub.modules.students.dto.StudentEntityDTO;
import com.pabloalbuquerque.student_hub.modules.students.entities.StudentEntity;
import com.pabloalbuquerque.student_hub.modules.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentUseCase {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntityDTO execute(StudentEntity studentEntity) {

        if (studentRepository.findByEmail(studentEntity.getEmail()).isPresent()) {
            throw new RuntimeException("Student already exists");
        }
        StudentEntity result = studentRepository.save(studentEntity);

        return new StudentEntityDTO(result);
    }
}
