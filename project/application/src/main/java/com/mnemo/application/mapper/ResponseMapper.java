package com.mnemo.application.mapper;

public interface ResponseMapper<S, T> {

	public S mapSingle(T entity);
}