package com.mnemo.application.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

public interface CrudService<T, ID> {

	public Page<T> getAll(Optional<String> type, Optional<String> order, Optional<String> value, Integer page);
	public T getSingle(ID id);
	public T save(T entity);
	public void delete(T entity);
}