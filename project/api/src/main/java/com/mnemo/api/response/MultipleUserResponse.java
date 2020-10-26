package com.mnemo.api.response;

import java.io.Serializable;
import java.util.List;

import com.mnemo.api.response.dto.PaginationResponseDto;
import com.mnemo.api.response.dto.UserResponseDto;

public class MultipleUserResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<UserResponseDto> users;
	private PaginationResponseDto pagination;
	
	public MultipleUserResponse() {
	}

	public MultipleUserResponse(List<UserResponseDto> users, PaginationResponseDto pagination) {
		this.users = users;
		this.pagination = pagination;
	}

	public List<UserResponseDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}

	public PaginationResponseDto getPagination() {
		return pagination;
	}

	public void setPagination(PaginationResponseDto pagination) {
		this.pagination = pagination;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pagination == null) ? 0 : pagination.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultipleUserResponse other = (MultipleUserResponse) obj;
		if (pagination == null) {
			if (other.pagination != null)
				return false;
		} else if (!pagination.equals(other.pagination))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
}
