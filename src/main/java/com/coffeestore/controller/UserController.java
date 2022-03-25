package com.coffeestore.controller;

import com.coffeestore.api.GHN.GHN_shipping;
import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.GHN.DistrictDto;
import com.coffeestore.query.dto.GHN.cityDTO;
import com.coffeestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    GHN_shipping ghn_shipping;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/cart")
    public String cart() {
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/user-info")
    public String getUserInfo(Model model, HttpServletRequest request) {
        String userEmail = request.getUserPrincipal().getName();
        User user = userService.getUserInfo(userEmail);

        model.addAttribute("user", user);
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


}
