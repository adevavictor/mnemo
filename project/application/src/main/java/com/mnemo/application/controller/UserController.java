package com.mnemo.application.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mnemo.api.request.UpdateUserRequest;
import com.mnemo.api.request.CreateUserRequest;
import com.mnemo.api.response.SingleUserResponse;
import com.mnemo.application.domain.User;
import com.mnemo.application.exception.BadRequestException;
import com.mnemo.application.exception.NotFoundException;
import com.mnemo.application.mapper.request.CreateUserRequestMapper;
import com.mnemo.application.mapper.request.UpdateUserRequestMapper;
import com.mnemo.application.mapper.response.UserResponseMapper;
import com.mnemo.application.service.impl.UserService;
import com.mnemo.application.utils.Constants;
import com.mnemo.application.utils.Utils;

@RestController
public class UserController {

	private final UserService service;
	private final UserResponseMapper responseMapper;
	private final CreateUserRequestMapper createRequestMapper;
	private final UpdateUserRequestMapper updateRequestMapper;
	
	public UserController(UserService service, UserResponseMapper responseMapper, CreateUserRequestMapper createRequestMapper, 
			UpdateUserRequestMapper updateRequestMapper) {
		this.service = service;
		this.responseMapper = responseMapper;
		this.createRequestMapper = createRequestMapper;
		this.updateRequestMapper = updateRequestMapper;
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
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody(required = true) @Valid CreateUserRequest request, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException(Utils.buildRequestErrorMessage(result));
		}
		
		User user = createRequestMapper.map(request);
		
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}
	
	@PatchMapping("/user/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable(name = "id", required = true) Long id,
			@RequestBody(required = true) @Valid UpdateUserRequest request, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new BadRequestException(Utils.buildRequestErrorMessage(result));
		}
			
		Optional<User> user = service.getSingle(id);
		
		if (!user.isPresent()) {
			throw new NotFoundException(String.format("%s%s", Constants.NOT_FOUND_MESSAGE, String.valueOf(id)));
		}
		
		User entity = updateRequestMapper.map(request, user.get());
		
		return ResponseEntity.ok(service.save(entity));
	}
}
