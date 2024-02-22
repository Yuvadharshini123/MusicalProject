package com.musical.project.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musical.project.Dto.CourseDto;
import com.musical.project.Entity.Courses;
import com.musical.project.Entity.TransactionDetails;
import com.musical.project.Entity.User;
import com.musical.project.Repository.CourseRepository;
import com.musical.project.Service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	//get All UIsers
	@GetMapping("/get")
    public List<Courses> getAllUsers(){
    	List<Courses> course=courseService.findAll();
    	return course;
	}
	
	//Add Course Posting
	 
	@PostMapping("/addCourse")
	public Courses postDetails(@RequestBody Courses course) {
		return courseService.saveDetails(course);
	}

	//Payment
		

	@GetMapping({"/createTransaction/{amount}"})
    public TransactionDetails createTransaction(@PathVariable(name="amount") Double amount) {
	   return courseService.createTransaction(amount);
	}

	
	
}

