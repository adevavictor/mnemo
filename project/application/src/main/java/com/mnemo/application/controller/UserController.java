package com.mnemo.application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mnemo.application.service.impl.UserService;

@RestController
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
}
