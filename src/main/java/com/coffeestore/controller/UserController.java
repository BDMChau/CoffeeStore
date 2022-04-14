package com.coffeestore.controller;

import com.coffeestore.api.GHN.GHN_shipping;
import com.coffeestore.model.user.Address;
import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.GHN.cityDTO;
import com.coffeestore.query.dto.OrderDto;
import com.coffeestore.query.repository.AddressRepo;
import com.coffeestore.service.order.OrderService;
import com.coffeestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
   private final UserService userService;

   @Autowired
   GHN_shipping ghn_shipping;

   @Autowired
   AddressRepo addressRepo;

   @Autowired
   OrderService orderService;

   public UserController(UserService userService) {
      this.userService = userService;
   }


   @RequestMapping("/admin")
   public String adminPage() {
      return "admin";
   }

   @GetMapping("/cart")
   public String cart() {
      return "cart";
   }

   @Transactional
   @GetMapping("/user-info")
   public String getUserInfo(Model model, HttpServletRequest request) {
      String userEmail = request.getUserPrincipal().getName();
      User user = userService.getUserInfo(userEmail);

      List<Address> addresses = addressRepo.getAddressByUserId(user.getId());
//        for (int i = 0; i < user.getAddresses().size(); i++) {
//            addresses.add(user.getAddresses().get(i));
//        }

      model.addAttribute("user", user);
      model.addAttribute("addresses", addresses);
      model.addAttribute("userForm", new User());

      Map citiesData = ghn_shipping.getCities();
      List cities = (List) citiesData.get("data");
      List<cityDTO> listCities = new ArrayList();
      cities.forEach(city -> {
         Map map = (Map) city;
         cityDTO cityDTO = new cityDTO();
         cityDTO.setProvinceName(String.valueOf(map.get("ProvinceName")));
         cityDTO.setProvinceID(String.valueOf(map.get("ProvinceID")));
         listCities.add(cityDTO);
      });

      model.addAttribute("cities", listCities);

   /*----- Orders -----*/
      List<OrderDto> orderDtoList = orderService.getUserOrders(userEmail, 0, 3);
      if (!orderDtoList.isEmpty()) {
         model.addAttribute("user_orders", orderDtoList);
      }

      Long totalOrders = orderService.getTotalOrders(userEmail);
      if(totalOrders != null){
         int totalPageOrders = orderService.getNumberOfPageOrders(totalOrders, 3);
         model.addAttribute("total_page_orders",totalPageOrders);
      }

      return "user/user_info";
   }

   @GetMapping("get-district/{city_id}")
   public ResponseEntity<Object> getDistrictsByCityId(@PathVariable("city_id") String city_id) {
      try {

         int provinceId = Integer.parseInt(city_id);

         Map districtsData = ghn_shipping.getDistricts(provinceId);

         return new ResponseEntity<>(districtsData, HttpStatus.OK);

      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

   }

   @GetMapping("get-ward/{district_id}")
   public ResponseEntity<Object> getWardByDistrictID(@PathVariable String district_id) {
      try {
         int districtId = Integer.parseInt(district_id);
         Map wardsData = ghn_shipping.getwards(districtId);

         return new ResponseEntity<>(wardsData, HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
   }


   @PostMapping("/user-info")
   public String updateUserInfo(Model model, @ModelAttribute("userForm") User userForm, BindingResult
      bindingResult) {
      userService.updateProfile(userForm);

      return "redirect:/user/user_info";
   }

   @PostMapping("/update-address")
   public ResponseEntity updateUserAddresses(@RequestBody Map data, HttpServletRequest request) {
      String userEmail = request.getUserPrincipal().getName();

      Map newAddress = userService.updateAddress(data, userEmail);

      Map<String, Object> msg = Map.of(
         "msg", "add address OK!",
         "address", newAddress
      );
      return new ResponseEntity<>(msg, HttpStatus.OK);
   }

   @PostMapping("/update-default-address")
   public ResponseEntity updateUserDefaultAddresses(@RequestBody Map data, HttpServletRequest request) {
      String userEmail = request.getUserPrincipal().getName();

      Map newDefaultAddress = userService.updateDefaultAddress(data, userEmail);

      Map<String, Object> msg = Map.of(
         "msg", "set default address OK!",
         "address_id", newDefaultAddress.get("address_id")
      );
      return new ResponseEntity<>(msg, HttpStatus.OK);
   }

   @PostMapping("/delete-address")
   public ResponseEntity deleteAddress(@RequestBody Map data, HttpServletRequest request) {
      String userEmail = request.getUserPrincipal().getName();
      Boolean isDeleted = userService.deleteAddress(data, userEmail);
      if (isDeleted.equals(false)) {
         Map<String, Object> err = Map.of(
            "err", "delete address failed!"
         );
         return new ResponseEntity<>(err, HttpStatus.OK);
      }

      Map<String, Object> msg = Map.of(
         "msg", "delete address OK!"
      );
      return new ResponseEntity<>(msg, HttpStatus.OK);
   }


   @GetMapping("/checkout")
   public String checkout(HttpServletRequest request, Model model) {
      String userEmail = request.getUserPrincipal().getName();
      Address address = userService.getMainAddress(userEmail);

      if (address == null) model.addAttribute("address", null);
      else {
         model.addAttribute("address", address);

         // shipping fee
         String city = address.getCity_province();
         String district = address.getDistrict();
         String ward = address.getWard();

         Map shippingFee = calcShippingFee(city, district, ward);
         if (shippingFee.isEmpty()) model.addAttribute("shipping_fee_err", "cannot calculate shipping fee!");
         else {
            Map data = Map.of(
               "message", shippingFee.get("message"),
               "serviceName", shippingFee.get("serviceName"),
               "total", shippingFee.get("total")
            );

            model.addAttribute("shipping_fee", data);
         }
      }

      return "checkout";
   }


   ////////////////// PRIVATE //////////////////
   private Map calcShippingFee(String city, String district, String ward) {
      Map mapToReturn = new HashMap();

      Boolean isFound = false;
      int cityId = 0;
      int districtId = 0;
      int wardId = 0;

      int serviceTypeId = 0;
      String serviceName = "";
      String message = "";


      // city
      Map getCities = ghn_shipping.getCities();
      List cities = (List) getCities.get("data");
      for (int i = 0; i < cities.size(); i++) {
         Map cityI = (Map) cities.get(i);

         if (cityI.get("ProvinceName").equals(city)) {
            cityId = Integer.parseInt(String.valueOf(cityI.get("ProvinceID")));
            isFound = true;
            break;
         }
      }

      if (isFound == false) return mapToReturn;
      isFound = false;

      // disctrict
      Map getDistricts = ghn_shipping.getDistricts(cityId);
      List districts = (List) getDistricts.get("data");
      for (int i = 0; i < districts.size(); i++) {
         Map districtI = (Map) districts.get(i);

         if (districtI.get("DistrictName").equals(district)) {
            districtId = Integer.parseInt(String.valueOf(districtI.get("DistrictID")));
            isFound = true;
            break;
         }
      }

      if (isFound == false) return mapToReturn;
      isFound = false;

      // ward
      Map getWards = ghn_shipping.getwards(districtId);
      List wards = (List) getWards.get("data");
      for (int i = 0; i < wards.size(); i++) {
         Map wardI = (Map) wards.get(i);

         if (wardI.get("WardName").equals(ward)) {
            wardId = Integer.parseInt(String.valueOf(wardI.get("WardCode")));
            isFound = true;
            break;
         }
      }

      if (isFound == false) return mapToReturn;


      // services
      Map getServices = ghn_shipping.getServices(districtId); // from Go Vap hcm
      List data = (List) getServices.get("data");
      Map data0 = (Map) data.get(0);

      message = String.valueOf(getServices.get("code_message_value"));
      serviceTypeId = Integer.parseInt(String.valueOf(data0.get("service_type_id")));
      serviceName = (String) data0.get("short_name");

      // fee
      Map getFee = ghn_shipping.getShippingFee(serviceTypeId, districtId, wardId);
      Map dataFee = new HashMap();
      if (getFee.isEmpty()) {
         getFee = ghn_shipping.getShippingFee(2, districtId, wardId);

         if (getFee.isEmpty()) {
            mapToReturn.put("message", "GHN đang có lỗi, đây là phí ship test!");
            mapToReturn.put("serviceName", "failed! (api GHN lỗi)");
            mapToReturn.put("total", 30000); // default
            return mapToReturn;
         }
      }

      dataFee = (Map) getFee.get("data");
      mapToReturn.put("total", dataFee.get("total"));
      mapToReturn.put("serviceName", serviceName);
      mapToReturn.put("message", message);

      return mapToReturn;
   }
}





