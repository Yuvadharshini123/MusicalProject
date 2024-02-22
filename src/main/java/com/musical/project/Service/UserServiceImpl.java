package com.musical.project.Service;

import java.util.HashSet;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.musical.project.Entity.Role;
import com.musical.project.Entity.User;
import com.musical.project.Exception.UserNotFoundException;
import com.musical.project.Repository.RoleRepository;
import com.musical.project.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;

	@Autowired 
	public RoleRepository roleRepository;
	




	
	   //Add Users -post
		@Override
		public User saveDetails(User user) {
			
			return userRepository.save(user);
		}
	
		@Override
		public void initRolesAndUser() {
			 Role adminRole=new Role();
			adminRole.setRoleName("Admin");
			adminRole.setRoleDesc("Admin Rolesss");
			roleRepository.save(adminRole);
			
			Role userRole=new Role();
			userRole.setRoleName("user");
			userRole.setRoleDesc("Default Role for newly created");
			roleRepository.save(userRole);
			
			User  adminUser =new User();
			adminUser.setFirstName("admin1");
			adminUser.setLastName("admin");
    		adminUser.setEmailId("admin@123");
			adminUser.setUserName("admin123");
		    adminUser.setUserPassword("Admin12345");
		
		    Set<Role> adminRoles=new HashSet<>();
    		 adminRoles.add(adminRole);
    		// adminUser.setRole(adminRoles);
	     	 userRepository.save(adminUser);

				User user =new User();
				user.setFirstName("yuva");
				user.setLastName("yuva");
				user.setEmailId("yuva@123");
			    user.setUserName("yuva123");
		        user.setUserPassword("yuva@12345");
				
				Set<Role> userRoles=new HashSet<>();
				 userRoles.add(userRole);
				 //user.setRole(userRoles);
			
     			 userRepository.save(user);
		}
		
	       //GET ALL USERS
	         @Override
	         public List<User> findAll() {
		
		        List<User> user=userRepository.findAll();
    	       return user;
	         }
        //Get User By Id
	         @Override
	     	public User getUserById(Long userId) {
	     		// TODO Auto-generated method stub
	     		Optional<User> optionalUser = userRepository.findById(userId);
	     		if (optionalUser.isEmpty()) {
	     			throw new UserNotFoundException("There is no User with Id:" + userId);
	     		}
	     		User user=optionalUser.get();
	     		return user; 		
	     	}


//	@Override
//	public User getUserByName(String name) {
//		
//		 return userRepository.findByName(name);
//	}

      // UPDATE USER
	    @Override
	      public User updateUsers(Long id) {
		
		return  userRepository.findById(id).get();
	}

  //Delete User
	@Override 
	public String deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			return "There is No User with Id:" + userId;
		}
		//delete user
		userRepository.deleteById(userId);
		return "User with Id: " + userId + " Delete Successfully";
		
	}
	
	





	





	


	



	






	

}
