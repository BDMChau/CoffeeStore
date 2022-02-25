package com.coffeestore.service.user;

import com.coffeestore.model.user.User;
import com.coffeestore.repository.user.RoleRepository;
import com.coffeestore.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.TimeZone;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setName();
        user.setEmail();
        user.setPhone();
        user.setAddresses();
        user.setAvatar();
        user.setBirthday();
        user.setGender();
        user.setCreated_at(Calendar.getInstance(TimeZone.getTimeZone("UTC")));

        userRepository.save(user);
    }


}
