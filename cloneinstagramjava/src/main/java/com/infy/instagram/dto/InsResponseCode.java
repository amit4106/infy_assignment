package com.infy.instagram.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InsResponseCode implements Serializable {

	public static final InsResponseCode SUCCESS = new InsResponseCode("0", "general.result.info.success");
	public static final InsResponseCode SYSTEM_ERROR = new InsResponseCode("GNL-0001", "general.system.error");
	public static final InsResponseCode BAD_REQUEST = new InsResponseCode("GNL-0002", "general.error.bad.request");
	private final String code;
	private final String message;

	public InsResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public static InsResponseCode getSuccess() {
		return SUCCESS;
	}

	public static InsResponseCode getSystemError() {
		return SYSTEM_ERROR;
	}

	public static InsResponseCode getBadRequest() {
		return BAD_REQUEST;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
