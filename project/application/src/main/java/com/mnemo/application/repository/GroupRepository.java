package com.mnemo.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.mnemo.application.domain.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {

}
