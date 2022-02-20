package com.coffeestore.repository;

import java.util.List;

import com.coffeestore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

}
