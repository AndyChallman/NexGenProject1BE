package com.skillstorm.exceptions;

public class InventoryNotFoundException extends RuntimeException {
	public InventoryNotFoundException(String message) {
		super(message);
	}
}
