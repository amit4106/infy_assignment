package com.infy.instagram.exception;

import java.util.Date;

public class InsErrorMessage {
	private Date timestamp;
	private String message;
	private Object data;

	public InsErrorMessage(Date timestamp, String message, Object data) {
		this.message = message;
		this.timestamp = timestamp;
		this.data = data;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
