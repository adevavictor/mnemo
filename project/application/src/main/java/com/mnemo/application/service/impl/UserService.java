package com.mnemo.application.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnemo.application.domain.User;
import com.mnemo.application.repository.UserRepository;
import com.mnemo.application.service.CrudService;

@Service
public class UserService implements CrudService<User, Long> {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> getAll(Optional<String> type, Optional<String> order, Optional<String> value, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getSingle(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public User save(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}
}
