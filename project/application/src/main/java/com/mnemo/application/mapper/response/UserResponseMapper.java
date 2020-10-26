package com.mnemo.application.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mnemo.api.response.MultipleUserResponse;
import com.mnemo.api.response.SingleUserResponse;
import com.mnemo.api.response.dto.GroupResponseDto;
import com.mnemo.api.response.dto.PaginationResponseDto;
import com.mnemo.api.response.dto.UserResponseDto;
import com.mnemo.application.domain.Group;
import com.mnemo.application.domain.User;
import com.mnemo.application.mapper.ResponseMapper;

@Component
public class UserResponseMapper implements ResponseMapper<SingleUserResponse, MultipleUserResponse, User> {

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

	@Override
	public MultipleUserResponse mapMultiple(Page<User> entity) {
		PaginationResponseDto pagination = new PaginationResponseDto();
		pagination.setPageNumer(entity.getPageable().getPageNumber());
		pagination.setOffset(entity.getPageable().getOffset());
		pagination.setPageSize(entity.getPageable().getPageSize());
		pagination.setTotalElements(entity.getTotalElements());
		pagination.setTotalPages(entity.getTotalPages());
		
		List<UserResponseDto> users = new ArrayList<UserResponseDto>();
		
		for (User user : entity.getContent()) {
			UserResponseDto userDto = new UserResponseDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setSurname(user.getSurname());
			userDto.setCode(user.getCode());
			
			List<GroupResponseDto> groups = new ArrayList<GroupResponseDto>();
			
			for (Group group: user.getGroups()) {
				GroupResponseDto groupDto = new GroupResponseDto();
				groupDto.setId(group.getId());
				groupDto.setName(group.getName());
				
				groups.add(groupDto);
			}
			
			userDto.setGroups(groups);
			users.add(userDto);
		}
		
		return new MultipleUserResponse(users, pagination);
	}
}
