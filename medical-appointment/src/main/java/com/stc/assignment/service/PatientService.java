package com.stc.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stc.assignment.data.dto.AppointmentDTO;
import com.stc.assignment.data.entity.AppointmentEntity;
import com.stc.assignment.data.entity.PatientEntity;
import com.stc.assignment.data.repository.PatientRepository;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public List<AppointmentDTO> getPatientAppointments(String patientId) {
		List<AppointmentDTO> list = new ArrayList<>();
		Optional<PatientEntity> optional = patientRepository.findById(Long.parseLong(patientId));
		if (optional.isPresent()) {
			PatientEntity entity = optional.get();
			List<AppointmentEntity> entityList = entity.getAppointmentsList();
			if (entityList != null && !entityList.isEmpty()) {
				for (AppointmentEntity appointmentEntity : entityList) {
					AppointmentDTO appointmentDTO = AppointmentDTO.toDTO(appointmentEntity);
					list.add(appointmentDTO);
				}
			}
		}
		return list;
	}

}
