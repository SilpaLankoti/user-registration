package com.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.error.UserNameAlreadyExistsException;
import com.user.error.UserNotExistsException;
import com.user.model.UserDetails;
import com.user.service.UserService;

@RestController
@Valid
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("user")
	public UserDetails getUserDetails(String userName) throws UserNotExistsException {
		return userService.getUserDetails(userName);
	}

	@PostMapping("user")
	public UserDetails saveUserDeatils(@Validated @RequestBody UserDetails userDetails)
			throws UserNameAlreadyExistsException {
		return userService.saveUserDeatils(userDetails);
	}

}
