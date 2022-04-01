package com.coffeestore.service.user;

import com.coffeestore.model.delivery.Delivery;
import com.coffeestore.model.order.OrderDetail;
import com.coffeestore.model.order.Orders;
import com.coffeestore.model.payment.Payment;
import com.coffeestore.model.product.Product;
import com.coffeestore.model.user.Address;
import com.coffeestore.model.user.Role;
import com.coffeestore.model.user.User;
import com.coffeestore.query.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class UserService {
   private String avatarDefault = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png";

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private PaymentRepository paymentRepository;

   @Autowired
   private OrderRepository orderRepository;

   @Autowired
   private DeliveryRepo deliveryRepo;

   @Autowired
   private AddressRepo addressRepo;

   @Autowired
   private RoleRepository roleRepository;

   @Autowired
   private OrderDetailRepository orderDetailRepository;

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
      if (addressOptional.isEmpty()) return null;

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


   public Long saveOrderVnPay(User user, Map data) {
     Calendar time = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

      Orders order = new Orders();
      order.setEmail(user.getEmail());
      order.setShipping_fee(BigDecimal.valueOf(Long.parseLong(String.valueOf(data.get("shipping_fee")))));
      order.setPhone(user.getPhone());
      order.setDescriptions("Thanh toán với vnpay");
      order.setUser(user);
      order.setCreated_at(time);
      order.setIs_completed(false);
      order.setTotal_bill(BigDecimal.valueOf(Long.parseLong(String.valueOf(data.get("total")))));

      // address
      Address address = addressRepo.getMainAddressByUserId(user.getId()).get();
      order.setAddress(address);

      // delivery
      Delivery delivery = deliveryRepo.getOne(1L);
      order.setDelivery(delivery);

      // payment
      Payment payment = paymentRepository.getOne(1L);
      order.setPayment(payment);

      orderRepository.saveAndFlush(order);

      Orders orderRes = orderRepository.findByCreated_at(time).get();

      List<Map> products = (List) data.get("products");
      products.forEach(item->{
         Product product = new Product();

         product.setCount_rating(Long.parseLong(String.valueOf(item.get("count_rating"))));
         product.setCount_purchased(Long.parseLong(String.valueOf(item.get("count_purchased"))));
         product.setCount_views(Long.parseLong(String.valueOf(item.get("count_views"))));
         product.setId(Long.parseLong(String.valueOf(item.get("pr_id"))));
         product.setDescription((String) item.get("pr_description"));
         product.setName((String) item.get("pr_name"));
         product.setPrice(BigDecimal.valueOf(Long.parseLong(String.valueOf(item.get("pr_price")))));
         product.setRating_star(Float.parseFloat(String.valueOf(item.get("rating_star"))));

         OrderDetail orderDetail = new OrderDetail();
         orderDetail.setOrders(orderRes);
         orderDetail.setProduct(product);
         orderDetail.setProduct_price(product.getPrice());
         orderDetail.setProduct_quantity(Integer.parseInt(String.valueOf(item.get("quantity"))));
         orderDetailRepository.saveAndFlush(orderDetail);
      });



      return orderRes.getId();
   }

   public void saveOrderCod(User user, Map data) {


   }

   @Transactional
   public boolean updateOrder(Long orderId) {
      Orders order = orderRepository.findById(orderId).get();
      order.setIs_completed(true);

      orderRepository.saveAndFlush(order);

      return true;
   }
}
