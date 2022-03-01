package com.coffeestore.service.auth;


import com.coffeestore.model.user.User;
import com.coffeestore.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        String userEmail = username;
        Optional<User> userOptional = userRepository.findByEmail(userEmail);
        if (!userOptional.isPresent()) throw new UsernameNotFoundException(userEmail);

        User user = userOptional.get();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        String userRoleName = user.getRole_id().getName();
        grantedAuthorities.add(new SimpleGrantedAuthority(userRoleName));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);

//        UserDetails user = user.withUsername(customer.getEmail()).password(customer.getPassword()).authorities("USER").build();
//        return user;
    }
}