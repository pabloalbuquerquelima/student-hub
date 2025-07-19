package com.pabloalbuquerque.student_hub.modules.repositories;

import com.pabloalbuquerque.student_hub.modules.entities.CertificationStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID> {

    @Query("SELECT c FROM certifications c WHERE c.studentEntity.email = :email AND c.technology = :technology")
    List<CertificationStudentEntity> findByStudentEntityId(String email, String technology);
}
