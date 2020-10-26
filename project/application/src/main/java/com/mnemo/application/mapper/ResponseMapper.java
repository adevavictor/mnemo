package com.mnemo.application.mapper;

import org.springframework.data.domain.Page;

public interface ResponseMapper<S, M, T> {

	public S mapSingle(T entity);
	public M mapMultiple(Page<T> entity);
}