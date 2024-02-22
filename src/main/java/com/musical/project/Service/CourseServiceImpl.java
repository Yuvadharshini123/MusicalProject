package com.musical.project.Service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musical.project.Dto.CourseDto;
import com.musical.project.Entity.Courses;
import com.musical.project.Entity.TransactionDetails;
import com.musical.project.Repository.CourseRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;


@Service

public class CourseServiceImpl implements CourseService {

	
	private static final String ORDER_PLACED="Placed";
	private static final String KEY="rzp_test_wMRUuqNEymVxhe";
	private static final String KEY_SECRET="TYJbwk0CipDMaW6ddLEsbN4V";
	private static final String CURRENCY ="INR";
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public List<Courses> findAll() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}


	@Override
	public Courses saveDetails(Courses course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	
	//Payment
	public TransactionDetails createTransaction(Double amount) {
		
		try {
			
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("amount",(amount*100));
		jsonObject.put("currency",CURRENCY);
		
		RazorpayClient razorpayClient=new RazorpayClient(KEY,KEY_SECRET);
		
		Order order= razorpayClient.orders.create(jsonObject);
		
		TransactionDetails transactionDetails=prepareTransaction(order);
		return transactionDetails;
		//System.out.println(order);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
        return null;
}
	   private TransactionDetails prepareTransaction(Order order) {
		   String orderId=order.get("id");
		   String currency=order.get("currency");
		   Integer amount=order.get("amount");
		   
		   TransactionDetails transactionDetails=new TransactionDetails(orderId,currency,amount);
		   return transactionDetails;
				   }
	   
	   
}