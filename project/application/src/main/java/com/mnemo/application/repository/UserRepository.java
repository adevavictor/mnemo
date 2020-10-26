package com.mnemo.application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mnemo.application.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
