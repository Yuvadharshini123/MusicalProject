package com.musical.project.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.musical.project.Entity.Payment;
import com.musical.project.Service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    
	@Autowired
	  private PaymentService paymentService;
	
	
	//add new Payment
	@PostMapping("/addpayment")
	public Payment addPayment(@RequestBody Payment payment){
		
		return paymentService.addPayment(payment);
		
	}
	
	//get All UIsers 
	@GetMapping("/payments")
    public List<Payment> getAllPayment(){
    	List<Payment> payment=paymentService.findAll();
    	return payment;
	}
	

	@PreAuthorize("hasRole('User')")
	@GetMapping({"/createTransaction/{amount}"})
    public void createTransaction(@PathVariable(name="") Double amount) {
		
	}
}


//	@GetMapping("/get/{id}")
//	public User getUser(@PathVariable int id) {
//	    User user = userRepository.findById(id).orElse(null); // Or handle the case when the user is not found
//	    return user;
//	
//	}
	
	//Create new User
//	 @PostMapping("/create")
//	 public void createUser(@RequestBody User user) {
//		userRepository.save(user); 
//	 }
//
//}


















//	@PostMapping("CreateNewUser")
//	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
//		String user1 = userRepository.save(user);
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(user1, HttpStatus.CREATED);
//		return responseEntity;
//	}

//	@GetMapping("/register")
//	public ResponseEntity<String> doLogin(@PathVariable("userType") String userType,
//			@PathVariable("userId") String userId, @PathVariable("password") String password) {
//		String user = userService.userLogin(userType, userId);
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
//		return responseEntity;
//	}

