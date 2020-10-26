package com.mnemo.application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mnemo.application.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public Page<User> findById(Long id, Pageable pageable);
	public Page<User> findByName(String name, Pageable pageable);
	public Page<User> findBySurname(String surname, Pageable pageable);
	public Page<User> findByCode(String code, Pageable pageable);
	public Page<User> findByGroups_Id(Long groupId, Pageable pageable);
	public Page<User> findByGroups_Name(String groupId, Pageable pageable);
	public boolean existsByCode(String code);
}
