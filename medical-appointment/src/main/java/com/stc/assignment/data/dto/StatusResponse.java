package com.stc.assignment.data.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class StatusResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7725423465837002562L;

	@ApiModelProperty(required = true, notes = "the code contains the error code of the service")
	private String code;
	@ApiModelProperty(required = true, notes = "the key contains the error key of the service, and this can be used to get other locales")
	private String key;
	@ApiModelProperty(required = true, notes = "the message contains the error message of the default locale, if the message with a specific locale not exist")
	private String message;

	public StatusResponse() {
	}

	public StatusResponse(String code, String key) {
		super();
		this.code = code;
		this.key = key;

	}

	public StatusResponse(String code, String key, String message) {
		super();
		this.code = code;
		this.key = key;
		this.message = message;

	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param message the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
