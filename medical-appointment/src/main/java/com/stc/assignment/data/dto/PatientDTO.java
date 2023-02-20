package com.stc.assignment.data.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stc.assignment.data.entity.PatientEntity;

public class PatientDTO {

	private Long id;

	private String name;

	private String phone;

	private String address;
	
	private List<AppointmentDTO> appointmentsList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AppointmentDTO> getAppointmentsList() {
		return appointmentsList;
	}

	public void setAppointmentsList(List<AppointmentDTO> appointmentsList) {
		this.appointmentsList = appointmentsList;
	}

	public static PatientDTO toDTO(PatientEntity entity) {

		PatientDTO dto = new PatientDTO();
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		dto.setName(entity.getName());
		dto.setPhone(entity.getName());
		dto.setAppointmentsList(entity.getAppointmentsList().stream()
				.map(i -> new AppointmentDTO(i.getId(), i.getDate(), i.getStatus(), i.getCancelationReason()))
				.collect(Collectors.toList()));
		return dto;

	}

	public static PatientEntity toDTO(PatientDTO dto) {

		PatientEntity entity = new PatientEntity();
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		entity.setName(dto.getName());
		entity.setPhone(dto.getName());
		return entity;

	}

}
