package com.mnemo.application.enums;

import org.springframework.util.StringUtils;

public enum Order {
	NA(""), ASC("asc"), DESC("desc");
	
	private String type;

	private Order(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static Order get(String type) {
		if (StringUtils.isEmpty(type)) {
			return Order.NA;
		}
		
		for (Order order: Order.values()) {
			if (type.equalsIgnoreCase(order.getType())) {
				return order;
			}
		}
		
		return Order.NA;
	}
}
