package com.stc.assignment.exception;

import com.stc.assignment.data.dto.StatusResponse;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StatusResponse statusResponse;

	public BusinessException(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}

	public BusinessException(String errorMessage) {
		super(errorMessage);
	}

	public BusinessException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public BusinessException(String code, String key, String message) {
		this.statusResponse = new StatusResponse(code, key, message);
	}

	public StatusResponse getStatusResponse() {
		return statusResponse;
	}

	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}

}
