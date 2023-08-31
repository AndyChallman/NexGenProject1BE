package com.skillstorm.exceptions;

public class WarehouseNotFoundException extends RuntimeException {
	public WarehouseNotFoundException(String message) {
		super(message);
}
}