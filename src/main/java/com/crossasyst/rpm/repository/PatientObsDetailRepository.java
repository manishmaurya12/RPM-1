package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.PatientObsDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PatientObsDetailRepository extends JpaRepository<PatientObsDetailEntity, Long> {

////    @Query("SELECT p FROM PatientObsDetailEntity p WHERE p.patientObsId =?1 ")
//    Optional<List<PatientObsDetailEntity>> findByPatientObsId(Long patientObsId);
}
