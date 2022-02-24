package com.coffeestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

@Query("SELECT c FROM Customer c WHERE c.id =?1")
    Optional<Customer> findCustomersById(Long id);

}
