package com.musical.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musical.project.Entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
