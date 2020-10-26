package com.mnemo.application.mapper;

public interface UpdateRequestMapper<R, T> {

	public T map(R request, T entity);
}
