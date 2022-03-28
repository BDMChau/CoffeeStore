package com.coffeestore.service.user;

import com.coffeestore.model.user.Address;
import com.coffeestore.model.user.Role;
import com.coffeestore.model.user.User;
import com.coffeestore.query.repository.AddressRepo;
import com.coffeestore.query.repository.RoleRepository;
import com.coffeestore.query.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class UserService {
  private String avatarDefault = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png";

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AddressRepo addressRepo;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public boolean register(User user) {
    Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
    if (userOptional.isPresent()) return false;

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


  public boolean updateProfile(User userInfo) {
    User user = getUserByEmail(userInfo.getEmail());
    if (user == null) return false;

//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setName(userInfo.getName());
//        user.setEmail(userInfo.getEmail());
    user.setPhone(userInfo.getPhone());
    user.setAddresses(userInfo.getAddresses());
//        user.setAvatar(avatarDefault);
    user.setBirthday(userInfo.getBirthday());
//        user.setGender();
//        user.setCreated_at(Calendar.getInstance(TimeZone.getTimeZone("UTC")));

//        Role role = roleRepository.getOne(1L); // role: USER
//        user.setRole(role);

    userRepository.saveAndFlush(user);

    return true;
  }

  public Map updateAddress(Map data, String userEmail) {
    User user = getUserInfo(userEmail);

    List<Address> addresses = addressRepo.getAddressByUserId(user.getId());
    boolean isMain = false;
    if (addresses.isEmpty()) {
      isMain = true;
    }
    Address address = new Address();
    address.setUser(user);
    address.setCity_province(String.valueOf(data.get("city")));
    address.setDistrict(String.valueOf(data.get("district")));
    address.setWard(String.valueOf(data.get("ward")));
    address.setAddress(String.valueOf(data.get("detail")));
    address.setIs_main(isMain);

    addressRepo.saveAndFlush(address);

    Map map = new HashMap();
    map.put("city", address.getCity_province());
    map.put("district", address.getDistrict());
    map.put("ward", address.getWard());
    map.put("user_id", address.getUser().getId());

    return map;
  }

  public Boolean deleteAddress(Map data, String userEmail) {
    User user = getUserInfo(userEmail);
    Long targetId = Long.parseLong(String.valueOf(data.get("address_id")));
    Optional<Address> addressOptional = addressRepo.findById(targetId);
    List<Address> addressList = addressRepo.getAddressByUserId(user.getId());
    if (addressList.size() == 1) {
      return false;
    }

    if (addressOptional.isPresent()) {
      addressRepo.delete(addressOptional.get());

      List<Address> addresses = addressRepo.getAddressByUserId(user.getId());
      if (addresses.size() == 1) {
        Address address = addresses.get(0);
        address.setIs_main(true);
        addressRepo.saveAndFlush(address);
      }
      return true;
    }

    return false;
  }


  public Map updateDefaultAddress(Map data, String userEmail) {
    User user = getUserInfo(userEmail);
    Long targetId = Long.parseLong(String.valueOf(data.get("address_id")));

    Map map = new HashMap();

    List<Address> addresses = addressRepo.getAddressByUserId(user.getId());
    addresses.forEach(address -> {
      if (address.getId().equals(targetId)) {
        address.setIs_main(true);
        map.put("address_id", address.getId());
      } else address.setIs_main(false);

      addressRepo.saveAndFlush(address);
    });


    return map;
  }

  public Address getMainAddress(String userEmail) {
    User user = getUserInfo(userEmail);

    Optional<Address> addressOptional = addressRepo.getMainAddressByUserId(user.getId());
    if(addressOptional.isEmpty()) return null;

    return addressOptional.get();
  }


  public User getUserInfo(String userEmail) {
    Optional<User> userOptional = userRepository.findByEmail(userEmail);
    return userOptional.orElseGet(User::new);
  }


  public User getUserByEmail(String email) {
    Optional<User> userOptional = userRepository.findByEmail(email);
    if (!userOptional.isPresent()) return null;

    return userOptional.get();
  }


}
