package com.mnemo.application.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mnemo.api.response.SingleUserResponse;
import com.mnemo.application.domain.User;
import com.mnemo.application.exception.NotFoundException;
import com.mnemo.application.mapper.impl.UserResponseMapper;
import com.mnemo.application.service.impl.UserService;
import com.mnemo.application.utils.Constants;

@RestController
public class UserController {

	private final UserService service;
	private final UserResponseMapper responseMapper;
	
	public UserController(UserService service, UserResponseMapper responseMapper) {
		this.service = service;
		this.responseMapper = responseMapper;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<SingleUserResponse> getUserById(@PathVariable(name = "id", required = true) Long id) {
		Optional<User> user = service.getSingle(id);
		
		if (!user.isPresent()) {
			throw new NotFoundException(String.format("%s%s", Constants.NOT_FOUND_MESSAGE, String.valueOf(id)));
		}
		
		SingleUserResponse response = responseMapper.mapSingle(user.get());
		
		return ResponseEntity.ok(response);
	}
}
