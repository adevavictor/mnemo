package com.mnemo.api.request.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Length(min = 3, max = 20, message = "User name is required and must have between 3 and 20 characters. ")
	private String name;
	
	@Length(min = 10, max = 40, message = "User surname is required and must have between 10 and 40 characters. ")
	private String surname;
	
	@Length(min = 10, max = 40, message = "User code is required and must have between 10 and 40 characters. ")
	private String code;
	
	@NotNull(message = "User must contain at least 1 group. ")
	@Valid
	private List<GroupRequestDto> groups;
	
	public UserRequestDto() {
	}

	public UserRequestDto(
			@Length(min = 3, max = 20, message = "User name must have between 3 and 20 characters. ") String name,
			@Length(min = 10, max = 40, message = "User surname must have between 10 and 40 characters. ") String surname,
			@Length(min = 10, max = 40, message = "User code must have between 10 and 40 characters. ") String code,
			@NotNull(message = "User must contain at least 1 group. ") @Valid List<GroupRequestDto> groups) {
		this.name = name;
		this.surname = surname;
		this.code = code;
		this.groups = groups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<GroupRequestDto> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupRequestDto> groups) {
		this.groups = groups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		UserRequestDto other = (UserRequestDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
}
