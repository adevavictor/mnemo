package com.mnemo.application.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mnemo.api.dto.GroupDto;
import com.mnemo.api.dto.UserDto;
import com.mnemo.api.response.SingleUserResponse;
import com.mnemo.application.domain.Group;
import com.mnemo.application.domain.User;
import com.mnemo.application.mapper.ResponseMapper;

@Component
public class UserResponseMapper implements ResponseMapper<SingleUserResponse, User> {

	@Override
	public SingleUserResponse mapSingle(User entity) {
		UserDto userDto = new UserDto();
		userDto.setId(entity.getId());
		userDto.setName(entity.getName());
		userDto.setSurname(entity.getSurname());
		userDto.setCode(entity.getCode());
		
		List<GroupDto> groups = new ArrayList<GroupDto>();
		
		for (Group group: entity.getGroups()) {
			GroupDto groupDto = new GroupDto();
			groupDto.setId(group.getId());
			groupDto.setName(group.getName());
			
			groups.add(groupDto);
		}
		
		userDto.setGroups(groups);
		
		return new SingleUserResponse(userDto);
	}

}
