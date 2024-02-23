package com.infy.instagram.service;

import com.infy.instagram.dto.UserCreateRequestDto;
import com.infy.instagram.entities.User;

public interface UserService {
	User createUser(UserCreateRequestDto request);
}
