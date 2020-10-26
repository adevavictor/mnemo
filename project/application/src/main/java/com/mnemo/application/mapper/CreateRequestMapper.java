package com.mnemo.application.mapper;

public interface CreateRequestMapper<R, T> {

	public T map(R request);
}
