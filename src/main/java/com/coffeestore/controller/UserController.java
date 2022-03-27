package com.coffeestore.controller;

import com.coffeestore.api.GHN.GHN_shipping;
import com.coffeestore.model.user.Address;
import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.GHN.DistrictDto;
import com.coffeestore.query.dto.GHN.cityDTO;
import com.coffeestore.query.repository.AddressRepo;
import com.coffeestore.service.user.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    GHN_shipping ghn_shipping;

    @Autowired
    AddressRepo addressRepo;

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

        return "user/user_info";
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
        if(isDeleted.equals(false)){
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
    public String checkout() {

        return "checkout";
    }
}
