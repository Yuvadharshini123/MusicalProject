package com.musical.project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.musical.project.Dto.CourseDto;
import com.musical.project.Entity.Courses;
import com.musical.project.Entity.TransactionDetails;


@Service
public interface CourseService {
	
     public List<Courses> findAll();   
	
	 public Courses saveDetails(Courses course);

	 public TransactionDetails createTransaction(Double amount);

	
}
