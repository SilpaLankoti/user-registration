package com.user.error;

public class UserNameAlreadyExistsException extends Exception {

	public UserNameAlreadyExistsException(String message) {
		super(message);
	}
}
