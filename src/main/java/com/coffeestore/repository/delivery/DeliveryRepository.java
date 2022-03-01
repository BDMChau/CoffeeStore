package com.coffeestore.repository.delivery;

import com.coffeestore.model.delivery.Delivery;
import com.coffeestore.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {


}

