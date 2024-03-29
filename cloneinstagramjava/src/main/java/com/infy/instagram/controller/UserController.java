package com.infy.instagram.controller;

import com.infy.instagram.config.LocalizationResolver;
import com.infy.instagram.dto.InsResponseCode;
import com.infy.instagram.dto.InsResponseEntity;
import com.infy.instagram.dto.UserCreateRequestDto;
import com.infy.instagram.entities.User;
import com.infy.instagram.modal.InsResultMessage;
import com.infy.instagram.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;
	private final LocalizationResolver localizationResolver;

	@Autowired
	public UserController(LocalizationResolver localizationResolver, UserService userService) {
		this.localizationResolver = localizationResolver;
		this.userService = userService;
	}

	@PostMapping("/api/create-user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserCreateRequestDto request) {

		User user = userService.createUser(request);

		log.info(request.toString());
		return InsResponseEntity.response(InsResponseCode.SUCCESS.getCode(), InsResponseCode.SUCCESS.getMessage(),
				HttpStatus.CREATED, user);
	}

	@GetMapping("/api/test")
	public String test() {
		return localizationResolver.resolve(InsResultMessage.USERNAME_NOTNULL_ERROR_MESSAGE);
	}
}
