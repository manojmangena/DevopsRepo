package com.acelerit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acelerit.model.entity.LoggingEntity;

@Repository
public interface LoggingRepository extends JpaRepository<LoggingEntity, Long> {

}

