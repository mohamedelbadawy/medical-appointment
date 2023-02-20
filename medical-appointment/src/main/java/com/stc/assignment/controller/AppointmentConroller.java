package com.stc.assignment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.assignment.data.dto.AppointmentDTO;
import com.stc.assignment.data.dto.StatusResponse;
import com.stc.assignment.exception.BusinessException;
import com.stc.assignment.request.AppointmentsRequest;
import com.stc.assignment.request.CancelAppointmentRequest;
import com.stc.assignment.service.AppointmentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping(path = "/appointment")
public class AppointmentConroller {
	
	private final AppointmentService appointmentService;
	
	public AppointmentConroller (AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@GetMapping(value = "/todatappointments")
    @ApiOperation(value = "Get all today appointments", response = AppointmentDTO.class, tags = {
            "Appointment-Controller"}, httpMethod = "GET", responseContainer = "Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = AppointmentDTO.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
            @ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class)})
	public ResponseEntity<?>getTodayAppointmets(){
		try {
			return new ResponseEntity<List<AppointmentDTO>>(appointmentService.getTodayAppointments(), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<StatusResponse>(ex.getStatusResponse(), HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<StatusResponse>(new StatusResponse("500","INTERNAL_SERVER_ERROR",e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}
	
	@PostMapping(value = "/addappointment")
    @ApiOperation(value = "Add new appointment", response = AppointmentDTO.class, tags = {
            "Appointment-Controller"}, httpMethod = "POST", responseContainer = "Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = AppointmentDTO.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
            @ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class)})
	public ResponseEntity<?>addNewAppointment(AppointmentDTO request){
		try {
			return new ResponseEntity<AppointmentDTO>(appointmentService.addNewAppointment(request),HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<StatusResponse>(ex.getStatusResponse(), HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<StatusResponse>(new StatusResponse("500","INTERNAL_SERVER_ERROR",e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}
	
	@PutMapping(value = "/canceladdappointment")
    @ApiOperation(value = "Cancel appointment", response = AppointmentDTO.class, tags = {
            "Appointment-Controller"}, httpMethod = "PUT", responseContainer = "Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = AppointmentDTO.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
            @ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class)})
	public  ResponseEntity<?> cancelAppointment(CancelAppointmentRequest request){
		try {
			return new ResponseEntity<AppointmentDTO>(appointmentService.cancelAppointment(request), HttpStatus.OK);

		} catch (BusinessException ex) {
			return new ResponseEntity<StatusResponse>(ex.getStatusResponse(), HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<StatusResponse>(new StatusResponse("500","INTERNAL_SERVER_ERROR",e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@PostMapping(value = "/appointmetsbydate/{date}")
    @ApiOperation(value = "Get all appointments by date", response = AppointmentDTO.class, tags = {
            "Appointment-Controller"}, httpMethod = "POST", responseContainer = "Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = AppointmentDTO.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
            @ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class)})
	public ResponseEntity<?>getAllAppointmentsByDate(AppointmentsRequest request){
		try {
			return new ResponseEntity<List<AppointmentDTO>>(appointmentService.getAppointmentsByDate(request.getDate()), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<StatusResponse>(ex.getStatusResponse(), HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<StatusResponse>(new StatusResponse("500","INTERNAL_SERVER_ERROR",e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}
	
	@GetMapping(value = "/patientappointments/{patientName}")
    @ApiOperation(value = "Get all appointments by patient name", response = AppointmentDTO.class, tags = {
            "Appointment-Controller"}, httpMethod = "GET", responseContainer = "Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = AppointmentDTO.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
            @ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class)})
	public ResponseEntity<?>getPatientAppointments(@PathVariable String patientName){
		try {
			return new ResponseEntity<List<AppointmentDTO>>(appointmentService.getPatientAppointments(patientName), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<StatusResponse>(ex.getStatusResponse(), HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<StatusResponse>(new StatusResponse("500","INTERNAL_SERVER_ERROR",e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}
	
	
}