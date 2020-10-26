package com.mnemo.api.response;

import java.io.Serializable;

import com.mnemo.api.dto.UserDto;

public class SingleUserResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UserDto user;
	
	public SingleUserResponse() {
	}

	public SingleUserResponse(UserDto user) {
		this.user = user;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
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
