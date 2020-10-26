package com.mnemo.api.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mnemo.api.request.dto.UserRequestDto;

public class UpdateUserRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "A user must be given. ")
	@Valid
	private UserRequestDto user;

	public UpdateUserRequest() {
	}
	
	public UpdateUserRequest(@NotNull(message = "A user must be given. ") @Valid UserRequestDto user) {
		this.user = user;
	}

	public UserRequestDto getUser() {
		return user;
	}

	public void setUser(UserRequestDto user) {
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
		UpdateUserRequest other = (UpdateUserRequest) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
