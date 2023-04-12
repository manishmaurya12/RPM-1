package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.EnterpriseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {


    @Query("SELECT  e from EnterpriseEntity e WHERE e.enterpriseId = :enterpriseId AND e.active = true")
    Optional<EnterpriseEntity> findByIdAndActiveTrue(Long enterpriseId);

    List<EnterpriseEntity> findByActiveTrue();


    @Override
    @Query("UPDATE EnterpriseEntity SET active = false WHERE enterpriseId = ?1")
    @Modifying
    void deleteById(Long enterpriseId);


}
