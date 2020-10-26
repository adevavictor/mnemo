package com.mnemo.api.response.dto;

import java.io.Serializable;

public class PaginationResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pageNumer;
	private Long offset;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	
	public PaginationResponseDto() {
	}

	public PaginationResponseDto(Integer pageNumer, Long offset, Integer pageSize, Long totalElements, Integer totalPages) {
		this.pageNumer = pageNumer;
		this.offset = offset;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
	}

	public Integer getPageNumer() {
		return pageNumer;
	}

	public void setPageNumer(Integer pageNumer) {
		this.pageNumer = pageNumer;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offset == null) ? 0 : offset.hashCode());
		result = prime * result + ((pageNumer == null) ? 0 : pageNumer.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((totalElements == null) ? 0 : totalElements.hashCode());
		result = prime * result + ((totalPages == null) ? 0 : totalPages.hashCode());
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
		PaginationResponseDto other = (PaginationResponseDto) obj;
		if (offset == null) {
			if (other.offset != null)
				return false;
		} else if (!offset.equals(other.offset))
			return false;
		if (pageNumer == null) {
			if (other.pageNumer != null)
				return false;
		} else if (!pageNumer.equals(other.pageNumer))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (totalElements == null) {
			if (other.totalElements != null)
				return false;
		} else if (!totalElements.equals(other.totalElements))
			return false;
		if (totalPages == null) {
			if (other.totalPages != null)
				return false;
		} else if (!totalPages.equals(other.totalPages))
			return false;
		return true;
	}
}
