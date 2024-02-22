package com.musical.project.Service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musical.project.Entity.Payment;
import com.musical.project.Repository.PaymentRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class PaymentService {
	
	private static final String ORDER_PLACED="Placed";
	private static final String KEY="rzp_test_wMRUuqNEymVxhe";
	private static final String KEY_SECRET="TYJbwk0CipDMaW6ddLEsbN4V";
	private static final String CURRENCY ="INR";
	
	@Autowired
	private PaymentRepo paymentRepo;

	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Payment addPayment(Payment payment) {
		
		return paymentRepo.save(payment);
	}
	
	public void createTransaction(Double amount) {
		
		try {
			
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("amount",(amount*100));
		jsonObject.put("currency",CURRENCY);
		RazorpayClient razorpayClient=new RazorpayClient(KEY,KEY_SECRET);
		
		Order order= razorpayClient.orders.create(jsonObject);
		System.out.println(order);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
