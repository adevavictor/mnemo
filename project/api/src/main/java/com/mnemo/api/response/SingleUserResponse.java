package com.mnemo.api.response;

import java.io.Serializable;

import com.mnemo.api.response.dto.UserResponseDto;

public class SingleUserResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UserResponseDto user;
	
	public SingleUserResponse() {
	}

	public SingleUserResponse(UserResponseDto user) {
		this.user = user;
	}

	public UserResponseDto getUser() {
		return user;
	}

	public void setUser(UserResponseDto user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		SingleUserResponse other = (SingleUserResponse) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
