package com.mnemo.application.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnemo.application.domain.User;
import com.mnemo.application.enums.Order;
import com.mnemo.application.enums.UserFilter;
import com.mnemo.application.exception.BadRequestException;
import com.mnemo.application.repository.UserRepository;
import com.mnemo.application.service.CrudService;
import com.mnemo.application.utils.Constants;
import com.mnemo.application.utils.Utils;

@Service
public class UserService implements CrudService<User, Long> {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> getAll(Optional<String> type, Optional<String> order, Optional<String> value, Integer page) {
		UserFilter filter = UserFilter.NA;
		
		if (type.isPresent()) {
			filter = UserFilter.getFilter(type.get());
			
			if (UserFilter.NA.equals(filter)) {
				throw new BadRequestException(String.format("%s%s", Constants.UNKNOWN_PARAMETER_VALUE_MESSAGE, filter.getName()));
			} else if (!UserFilter.isValid(filter.getValidationType(), value)) {
				throw new BadRequestException(String.format("%s%s", Constants.WRONG_PARAMETER_VALUE_MESSAGE, filter.getName()));
			}
		}
		
		Pageable pageable = Utils.buildPagination(order.isPresent() ? Order.get(order.get()) : Order.NA, UserFilter.ID.getName(), page);
		String val = value.isPresent() ? value.get() : null;
		Page<User> users = null;
		
		switch(filter) {
			case ID:
				users = repository.findById(Long.valueOf(val), pageable);
				break;
			case NAME:
				users = repository.findByName(val, pageable);
				break;
			case SURNAME:
				users = repository.findBySurname(val, pageable);
				break;
			case CODE:
				users = repository.findByCode(val, pageable);
				break;
			case GROUP_ID:
				users = repository.findByGroups_Id(Long.valueOf(val), pageable);
				break;
			case GROUP_NAME:
				users = repository.findByGroups_Name(val, pageable);
				break;
			case NA:
			default:
				users = repository.findAll(pageable);
				break;
		}
		
		return users;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getSingle(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public User save(User entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void delete(User entity) {
		repository.delete(entity);
	}
	
	@Transactional(readOnly = true)
	public boolean existsByCode(String code) {
		return repository.existsByCode(code);
	}
}
