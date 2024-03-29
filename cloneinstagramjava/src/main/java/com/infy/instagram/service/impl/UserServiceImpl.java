package com.infy.instagram.service.impl;

import com.infy.instagram.config.LocalizationResolver;
import com.infy.instagram.dto.UserCreateRequestDto;
import com.infy.instagram.entities.User;
import com.infy.instagram.mapper.UserMapper;
import com.infy.instagram.modal.InsResultMessage;
import com.infy.instagram.repository.UserRepository;
import com.infy.instagram.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final LocalizationResolver localizationResolver;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, LocalizationResolver localizationResolver) {
		this.userRepository = userRepository;
		this.localizationResolver = localizationResolver;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public User createUser(UserCreateRequestDto request) {

		User user = UserMapper.USER_INSTANCE.userDtoToUser(request);
		if (userRepository.findByUsername(user.getUsername()).isPresent())
			throw new IllegalArgumentException(localizationResolver.resolve(InsResultMessage.USERNAME_MUST_BE_UNIQUE));

		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		return user;
	}
}
