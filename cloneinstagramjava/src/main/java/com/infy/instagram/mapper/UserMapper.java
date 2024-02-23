package com.infy.instagram.mapper;

import com.infy.instagram.dto.UserCreateRequestDto;
import com.infy.instagram.entities.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
	
	UserMapper USER_INSTANCE = Mappers.getMapper(UserMapper.class);

	User userDtoToUser(UserCreateRequestDto userDto);
}
