package com.coffeestore.repository.payment;

import com.coffeestore.model.feedback.Feedback;
import com.coffeestore.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


}
