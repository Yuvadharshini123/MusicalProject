package com.musical.project.Controller;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.musical.project.Entity.User;
import com.musical.project.Service.UserService;

import jakarta.annotation.PostConstruct;





@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostConstruct
	public void initRolesAndUser() {
		userService.initRolesAndUser();
	}
	
	//Add User -Register New User
		@PostMapping({"/registerNewUser"})
		public User registerNewUser(@RequestBody User user) {
			return userService.saveDetails(user);
		}
		
//		@GetMapping("user/login/{userType}/userId}/{userPassword}")
//		public ResponseEntity<String> doLogin(
//				@PathVariable("userId") String userId, @PathVariable("password") String userPassword) {
//			String user = userService.userLogin(userId, userPassword);
//			ResponseEntity<String> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
//			return responseEntity;
//		}
		
		@GetMapping({"/forAdmin"})
      public String forAdmin()	{
			return "This Url is Accessible for Admin Only";
		}
		@GetMapping({"/forUser"})
	      public String forUser()	{
				return "This Url is Accessible for the User";
			}
	
	//get All UIsers
		@GetMapping("/getAllUsers")
	    public List<User> getAllUsers(){
	    	List<User> user=userService.findAll();
	    	return user;
		}
	

		
//	      //GetUserBY name
//	      @GetMapping("/getUserByName/{firstName}")
//	      public User getUserByName(@PathVariable String firstName) {
//	    	  return userService.getUserByName(firstName);
//	      }
     	
		// For Update 
     	@PutMapping("/update/{id}")
     	public User updateUsers(@PathVariable Long id) {
     		User userUpd= userService.updateUsers(id);
     	 userUpd.setFirstName("pavi");
     	 userService.saveDetails(userUpd);
     	 return userUpd;
     	}
     	//Delete User 
     	@DeleteMapping("DeleteUser/{userId}")
    	public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
    		String response = userService.deleteUserById(userId);
    		ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
    		return responseEntity;

    	}
     	//Delete User 
     	@GetMapping("getUserById/{userId}")
    	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
    		User response = userService.getUserById(userId);
    		ResponseEntity<User> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
    		return responseEntity;

    	}
	    
}
