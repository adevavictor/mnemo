package com.mnemo.application.mapper.request;

import org.springframework.stereotype.Component;

import com.mnemo.api.request.UpdateUserRequest;
import com.mnemo.api.request.dto.UserRequestDto;
import com.mnemo.application.domain.User;
import com.mnemo.application.mapper.UpdateRequestMapper;

@Component
public class UpdateUserRequestMapper implements UpdateRequestMapper<UpdateUserRequest, User> {

	@Override
	public User map(UpdateUserRequest request, User entity) {
		UserRequestDto userDto = request.getUser();
		
		entity.setName(userDto.getName());
		entity.setSurname(userDto.getSurname());
		entity.setCode(userDto.getCode());
		
		return entity;
	}
}
