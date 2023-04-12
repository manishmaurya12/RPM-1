package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.PatientObsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PatientObsRepository extends JpaRepository<PatientObsEntity, Long> {
//    @Query("SELECT p FROM PatientObsEntity p WHERE p.patientId =?1 ")
//    Optional<List<PatientObsEntity>> findALLPatientObs(Long patientObsId);

   // @Query("SELECT p FROM PatientObsEntity p WHERE p.patientId =?1 ")
   List<PatientObsEntity> findByPatientId(Long patientId);
}
