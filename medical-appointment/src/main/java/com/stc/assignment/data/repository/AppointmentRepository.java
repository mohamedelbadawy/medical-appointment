package com.stc.assignment.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stc.assignment.data.entity.AppointmentEntity;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
	
	public Optional<AppointmentEntity> findById(Long id) ;
	
	public List<AppointmentEntity> findByDateAndStatus(Date date, Integer status);
		
	@Query(value = "SELECT * FROM appointment where patient_id in (select id from patient where patient_name = ?)", nativeQuery = true)
	public List<AppointmentEntity> findByPatientName(String patientName);


}
