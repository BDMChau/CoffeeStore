package com.coffeestore.repository.user;

import com.coffeestore.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);


    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);


}