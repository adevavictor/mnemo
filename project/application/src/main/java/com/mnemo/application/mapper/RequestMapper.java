package com.mnemo.application.mapper;

public interface RequestMapper<R, T> {

	public T map(R request);
}
