package com.mnemo.application.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mnemo.api.request.PostUserRequest;
import com.mnemo.api.response.SingleUserResponse;
import com.mnemo.application.domain.User;
import com.mnemo.application.exception.BadRequestException;
import com.mnemo.application.exception.NotFoundException;
import com.mnemo.application.mapper.request.UserRequestMapper;
import com.mnemo.application.mapper.response.UserResponseMapper;
import com.mnemo.application.service.impl.UserService;
import com.mnemo.application.utils.Constants;
import com.mnemo.application.utils.Utils;

@RestController
public class UserController {

	private final UserService service;
	private final UserResponseMapper responseMapper;
	private final UserRequestMapper requestMapper;
	
	public UserController(UserService service, UserResponseMapper responseMapper, UserRequestMapper requestMapper) {
		this.service = service;
		this.responseMapper = responseMapper;
		this.requestMapper = requestMapper;
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
	public ResponseEntity<User> saveUser(@RequestBody(required = true) @Valid PostUserRequest request, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException(Utils.buildRequestErrorMessage(result));
		}
		
		User user = requestMapper.map(request);
		
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}
}
