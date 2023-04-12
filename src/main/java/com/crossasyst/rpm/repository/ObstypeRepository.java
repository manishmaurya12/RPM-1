package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.ObstermEntity;
import com.crossasyst.rpm.entity.ObstypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObstypeRepository extends JpaRepository<ObstypeEntity, Long> {
}
