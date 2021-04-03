package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.user.error.UserNameAlreadyExistsException;
import com.user.error.UserNotExistsException;
import com.user.model.UserDetails;
import com.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	public Boolean generateUserName(String firstName, String lastName) {
		String username = getUserName(firstName, lastName);
		return userRepository.findByUserName(username) != null;
	}

	public UserDetails saveUserDeatils(UserDetails userDetails) throws UserNameAlreadyExistsException {
		if (generateUserName(userDetails.getFirstName(), userDetails.getLastName())) {
			throw new UserNameAlreadyExistsException("username already exists");
		}
		String username = getUserName(userDetails.getFirstName(), userDetails.getLastName());
		userDetails.setUserName(username);
		UserDetails userDetailsFromDB = userRepository.save(userDetails);
		sendMail(userDetailsFromDB);
		return userDetailsFromDB;
	}

	public String getUserName(String firstName, String lastName) {
		return firstName.substring(0, 3).concat(lastName.substring(0, 3));
	}

	public UserDetails getUserDetails(String userName) throws UserNotExistsException {
		UserDetails userFromDb = userRepository.findByUserName(userName);
		if (userFromDb == null) {
			throw new UserNotExistsException("Username is not found in DB");
		}
		return userFromDb;
	}

	public void sendMail(UserDetails userDetails) throws MailException, UserNameAlreadyExistsException {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo("lankoti.silpa@gmail.com");
			mailMessage.setSubject("user registered succesfully");
			mailMessage.setText("username:"+userDetails.getUserName() +" is registered!" );
			javaMailSender.send(mailMessage);
	}
}
