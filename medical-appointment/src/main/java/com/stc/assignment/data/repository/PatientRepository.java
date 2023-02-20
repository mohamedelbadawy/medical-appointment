package com.stc.assignment.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stc.assignment.data.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long>{
	
	public Optional<PatientEntity> findById(Long id);

}
