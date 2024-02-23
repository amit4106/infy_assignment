package com.infy.instagram.dto;

import com.infy.instagram.modal.InsResultMessage;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class UserCreateRequestDto {

	@NotNull(message = InsResultMessage.USERNAME_NOTNULL_ERROR_MESSAGE)
	@Size(min = 3, max = 10, message = InsResultMessage.USERNAME_SIZE_ERROR_MESSAGE)
	private String username;
	@NotNull(message = InsResultMessage.DISPLAY_NAME_NOTNULL_ERROR_MESSAGE)
	private String displayName;
	@NotNull(message = InsResultMessage.PASSWORD_NOTNULL_ERROR_MESSAGE)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
