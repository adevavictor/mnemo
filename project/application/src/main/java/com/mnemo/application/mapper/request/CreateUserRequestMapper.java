package com.mnemo.application.mapper.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mnemo.api.request.CreateUserRequest;
import com.mnemo.api.request.dto.GroupRequestDto;
import com.mnemo.api.request.dto.UserRequestDto;
import com.mnemo.application.domain.Group;
import com.mnemo.application.domain.User;
import com.mnemo.application.mapper.CreateRequestMapper;

@Component
public class CreateUserRequestMapper implements CreateRequestMapper<CreateUserRequest, User> {

	@Override
	public User map(CreateUserRequest request) {
		UserRequestDto userDto = request.getUser();
		
		User user = new User();
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setCode(userDto.getCode());
		
		List<Group> groups = new ArrayList<Group>();
		
		for (GroupRequestDto groupDto: userDto.getGroups()) {
			Group group = new Group();
			group.setId(groupDto.getId());
			group.setName(groupDto.getName());
			
			groups.add(group);
		}
		
		user.setGroups(groups);
		
		return user;
	}
}