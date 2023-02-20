package com.stc.assignment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.assignment.data.dto.AppointmentDTO;
import com.stc.assignment.data.dto.StatusResponse;
import com.stc.assignment.exception.BusinessException;
import com.stc.assignment.service.PatientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {
	
	private final PatientService patientService;
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping(value = "/patienthistory/{patientId}")
    @ApiOperation(value = "Get all patient appointments history", response = AppointmentDTO.class, tags = {
            "Patient-Controller"}, httpMethod = "GET", responseContainer = "Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = AppointmentDTO.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
            @ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class)})
	public ResponseEntity<?>getPatientAppointments(String patientId){
		try {
			return new ResponseEntity<List<AppointmentDTO>>(patientService.getPatientAppointments(patientId), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<StatusResponse>(ex.getStatusResponse(), HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<StatusResponse>(new StatusResponse("500","INTERNAL_SERVER_ERROR",e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}

}
