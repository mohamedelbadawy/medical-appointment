package com.stc.assignment.data.dto;

import java.util.Date;

import com.stc.assignment.data.entity.AppointmentEntity;
import com.stc.assignment.data.entity.PatientEntity;

public class AppointmentDTO {

	private Long id;

	private Date date;

	private Integer status;

	private String cancelationReason;

	private PatientDTO patient;

	public AppointmentDTO(Long id, Date date, Integer status, String cancelationReason) {
		this.id = id;
		this.date = date;
		this.status = status;
		this.cancelationReason = cancelationReason;
	}

	public AppointmentDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCancelationReason() {
		return cancelationReason;
	}

	public void setCancelationReason(String cancelationReason) {
		this.cancelationReason = cancelationReason;
	}

	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}

	public static AppointmentDTO toDTO(AppointmentEntity entity) {
		AppointmentDTO dto = new AppointmentDTO();
		dto.setId(entity.getId());
		dto.setCancelationReason(entity.getCancelationReason());
		dto.setDate(entity.getDate());
		dto.setStatus(entity.getStatus());
		PatientDTO patientDTO = new PatientDTO();
		if (entity.getPatient() != null) {
			patientDTO.setId(entity.getPatient().getId());
			patientDTO.setAddress(entity.getPatient().getAddress());
			patientDTO.setName(entity.getPatient().getName());
			patientDTO.setPhone(entity.getPatient().getName());
		}
		dto.setPatient(patientDTO);
		return dto;

	}

	public static AppointmentEntity toEntity(AppointmentDTO dto) {
		AppointmentEntity entity = new AppointmentEntity();
		entity.setId(dto.getId());
		entity.setCancelationReason(dto.getCancelationReason());
		entity.setDate(dto.getDate());
		entity.setStatus(dto.getStatus());
		PatientEntity patientEntity = new PatientEntity();
		if (dto.getPatient() != null) {
			patientEntity.setId(dto.getPatient().getId());
		}
		entity.setPatient(patientEntity);
		return entity;
	}
}
