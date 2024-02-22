package com.musical.project.Service;

import java.util.List;
import java.util.Optional;

import com.musical.project.Entity.User;


public interface UserService {

	List<User> findAll();

	User saveDetails(User user);
	void initRolesAndUser();
	
//
	public User getUserById(Long userId);
//
//	User getUserByName(String name);

	User updateUsers(Long id);

	String deleteUserById(Long userId);

	

	

	
    
	
	
	

}
