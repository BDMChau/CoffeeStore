package com.coffeestore.query.repository;

import com.coffeestore.model.user.Address;
import com.coffeestore.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.user.id = ?1 order by a.is_main DESC")
    List<Address> getAddressByUserId(Long userId);

    @Query("select a from Address a where a.user.id = ?1 AND a.is_main = true")
    Optional<Address> getMainAddressByUserId(Long userId);
}