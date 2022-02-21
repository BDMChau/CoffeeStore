package com.coffeestore.repository;

import java.util.List;
import java.util.Optional;

import com.coffeestore.model.Customer;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

@Query("SELECT c FROM Customer c WHERE c.id =?1")
    Optional<Customer> findCustomersById(Long id);

}
