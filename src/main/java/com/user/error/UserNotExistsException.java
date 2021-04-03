package com.user.error;

public class UserNotExistsException extends Exception {
	public UserNotExistsException(String message) {
		super(message);
	}
}
