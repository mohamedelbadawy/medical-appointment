package com.stc.assignment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stc.assignment.constant.ApplicationConstant;
import com.stc.assignment.data.dto.AppointmentDTO;
import com.stc.assignment.data.entity.AppointmentEntity;
import com.stc.assignment.data.repository.AppointmentRepository;
import com.stc.assignment.request.CancelAppointmentRequest;

@Service
public class AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	
	
	public AppointmentService(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
		
	}
	
	public List<AppointmentDTO> getTodayAppointments(){
		List<AppointmentDTO> list = new ArrayList<>();
		List<AppointmentEntity> entityList = appointmentRepository.findByDateAndStatus(new Date(), ApplicationConstant.ACTIVE_STATUS);
		if(entityList != null && !entityList.isEmpty()) {
			for(AppointmentEntity entity: entityList) {
				AppointmentDTO appointmentDTO = AppointmentDTO.toDTO(entity);
				list.add(appointmentDTO);
			}
		}
		return list;
	}
	
	public AppointmentDTO addNewAppointment(AppointmentDTO dto) {
		AppointmentEntity entity = AppointmentDTO.toEntity(dto);
		appointmentRepository.save(entity);
		return AppointmentDTO.toDTO(entity);
	}
	
	public AppointmentDTO cancelAppointment(CancelAppointmentRequest request) {
		AppointmentDTO dto = new AppointmentDTO();
		Optional<AppointmentEntity> optinal = appointmentRepository.findById(request.getId());
		if(optinal.isPresent()) {
			AppointmentEntity appointmentEntity = optinal.get();
			appointmentEntity.setStatus(ApplicationConstant.CANCELED_STATUS);
			appointmentEntity.setCancelationReason(request.getReason());
			appointmentRepository.save(appointmentEntity);
			dto = AppointmentDTO.toDTO(appointmentEntity);
		}
		return dto;
	}
	
	public List<AppointmentDTO> getAppointmentsByDate(String date) throws ParseException{
		List<AppointmentDTO> list = new ArrayList<>();
	    Date formattedDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		List<AppointmentEntity> entityList = appointmentRepository.findByDateAndStatus(formattedDate, ApplicationConstant.ACTIVE_STATUS);
		if(entityList != null && !entityList.isEmpty()) {
			for(AppointmentEntity entity: entityList) {
				AppointmentDTO appointmentDTO = AppointmentDTO.toDTO(entity);
				list.add(appointmentDTO);
			}
		}
		return list;
	}
	
	public List<AppointmentDTO> getPatientAppointments(String patientName){
		List<AppointmentDTO> list = new ArrayList<>();
		List<AppointmentEntity> entityList = appointmentRepository.findByPatientName(patientName);
		if(entityList != null && !entityList.isEmpty()) {
			for(AppointmentEntity entity: entityList) {
				AppointmentDTO appointmentDTO = AppointmentDTO.toDTO(entity);
				list.add(appointmentDTO);
			}
		}
		return list;
		
	}


}
