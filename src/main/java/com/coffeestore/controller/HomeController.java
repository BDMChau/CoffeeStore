package com.coffeestore.controller;

import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.brand.BrandService;
import com.coffeestore.service.product.ProductService;
import com.coffeestore.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    final UserService userService;
    final ProductService productService;
    final BrandService brandService;


    public HomeController(UserService userService, ProductService productService, BrandService brandService) {
        this.userService = userService;
        this.productService = productService;
        this.brandService = brandService;
    }


    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {

        /* default variable */
        int from = 0;
        int amount = 10;

        /*--- User  ---*/
//        User user = null;
//        if (request.getUserPrincipal() != null) {
//            String email = request.getUserPrincipal().getName();
//            user = userService.getUserByEmail(email);
//        }
//        if (user == null) return "home";
//
//        HttpSession session = request.getSession();
//        session.setAttribute("userId", user.getId());
//        session.setAttribute("email", user.getEmail());

        /*--- top products ---*/

        List<ProductDto> listRatedProducts = productService.getTopProducts(2, from, amount);
        List<ProductDto> listPurchasedProducts = productService.getTopProducts(3, from, amount);

        if (listRatedProducts.isEmpty()) {
            model.addAttribute("error", "list rated products is empty!");
        } else model.addAttribute("list_rated_products", listRatedProducts);

        if (listPurchasedProducts.isEmpty()) {
            model.addAttribute("error", "list purchased products is empty!");
        } else model.addAttribute("list_purchased_product", listPurchasedProducts);

        /*--- brand's products ---*/

        Long nestcafeId = 3L;
        Long vinastarId = 2L;

        List<ProductDto> nestcafeProductsList = brandService.getProductsByBrand(nestcafeId, from ,amount);
        List<ProductDto> vinastarProductsList = brandService.getProductsByBrand(vinastarId, from ,amount);
        if (listRatedProducts.isEmpty()) {
            model.addAttribute("error", "list nest cafe's products is empty!");
        } else model.addAttribute("list_nestcafe_products", nestcafeProductsList);


        if (listPurchasedProducts.isEmpty()) {
            model.addAttribute("error", "list purchased products is empty!");
        } else model.addAttribute("list_vinastar_product", vinastarProductsList);

        /*-- Article about cafe --*/
        // đợi nhân hứa làm
        nestcafeProductsList.forEach(System.err::println);
        System.err.println(" nestcafeProductsList: "+  nestcafeProductsList.size());

        return "home";
    }


    @GetMapping("/{brand_id}/page") // products of id
    public String GetProductsOfBrand(@PathVariable String brand_id, @RequestParam int page, Model model) {

        Long brandId = 0L;
        if (!brand_id.equals("")) {
            brandId = Long.parseLong(brand_id);
        }
        if(page <= 0){
            model.addAttribute("err","something wrong!");

        } else page -= 1;
        int from = page * 10;
        int amount = from +10;

        List<ProductDto> productDtoList = brandService.getProductsByBrand(brandId, from ,amount);
        productDtoList.forEach(System.err::println);
        model.addAttribute("list_product", productDtoList);
        return "brandproducts";
    }



    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/brand")
    public String brandPage() {
        return "brand";
    }


    @RequestMapping("/user")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/shop")
    public String shopPage() {
        return "shop";
    }

    @RequestMapping("/user-info")
    public String userInfoPage() {
        return "user/user_info";
    }

    @RequestMapping("/paywithvnpay")
    public String payWithVnpay() {
        return "payment/vnpay/index";
    }

    @RequestMapping("/userrr")
    public String user() {
        return "userrr";
    }


}
