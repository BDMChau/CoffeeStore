package com.coffeestore.service.user;

import com.coffeestore.model.user.Role;
import com.coffeestore.model.user.User;
import com.coffeestore.query.repository.user.RoleRepository;
import com.coffeestore.query.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class UserService {
    private String avatarDefault = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean register(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()) return false;

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setName(user.getName());
        user.setEmail(user.getEmail());
//        user.setPhone();
//        user.setAddresses();
        user.setAvatar(avatarDefault);
//        user.setBirthday();
//        user.setGender();
        user.setCreated_at(Calendar.getInstance(TimeZone.getTimeZone("UTC")));

        Role role = roleRepository.getOne(1L); // role: USER
        user.setRole(role);

        userRepository.saveAndFlush(user);
        return true;
    }



//    public boolean updateProfile(User user){
//        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
//        if(userOptional.isEmpty()) {
//            return false;
//        }
//
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setName(user.getName());
//        user.setEmail(user.getEmail());
////        user.setPhone();
////        user.setAddresses();
//        user.setAvatar(avatarDefault);
////        user.setBirthday();
////        user.setGender();
//        user.setCreated_at(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
//
//        Role role = roleRepository.getOne(1L); // role: USER
//        user.setRole(role);
//
//        userRepository.saveAndFlush(user);
//
//        userRepository.saveAndFlush(user);
//        return true;
//    }


    public User getUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isPresent()) return null;

        return userOptional.get();
    }
}
