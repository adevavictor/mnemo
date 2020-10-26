package com.mnemo.api.request.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class GroupRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Group ID must not be empty. ")
	private Long id;
	
	@NotEmpty(message = "Group name must not me empty. ")
	@Length(min = 3, max = 20, message = "Group name must have between 3 and 20 characters. ")
	private String name;

	public GroupRequestDto() {
	}

	public GroupRequestDto(@NotNull(message = "Group ID must not be empty. ") Long id,
			@NotEmpty(message = "Group name must not me empty. ") String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupRequestDto other = (GroupRequestDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
