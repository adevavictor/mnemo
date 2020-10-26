package com.mnemo.application.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mnemo.api.response.SingleUserResponse;
import com.mnemo.api.response.dto.GroupResponseDto;
import com.mnemo.api.response.dto.UserResponseDto;
import com.mnemo.application.domain.Group;
import com.mnemo.application.domain.User;
import com.mnemo.application.mapper.ResponseMapper;

@Component
public class UserResponseMapper implements ResponseMapper<SingleUserResponse, User> {

	@Override
	public SingleUserResponse mapSingle(User entity) {
		UserResponseDto userDto = new UserResponseDto();
		userDto.setId(entity.getId());
		userDto.setName(entity.getName());
		userDto.setSurname(entity.getSurname());
		userDto.setCode(entity.getCode());
		
		List<GroupResponseDto> groups = new ArrayList<GroupResponseDto>();
		
		for (Group group: entity.getGroups()) {
			GroupResponseDto groupDto = new GroupResponseDto();
			groupDto.setId(group.getId());
			groupDto.setName(group.getName());
			
			groups.add(groupDto);
		}
		
		userDto.setGroups(groups);
		
		return new SingleUserResponse(userDto);
	}

}
