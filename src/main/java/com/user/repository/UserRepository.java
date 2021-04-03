package com.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.model.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Integer> {
	public UserDetails findByUserName(String userName);


}
