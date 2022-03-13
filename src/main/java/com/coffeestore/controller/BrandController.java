package com.coffeestore.controller;

import com.coffeestore.model.product.Brand;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.brand.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{brand_id}") // products of id
    public String GetBrandInfo(@PathVariable String brand_id, Model model) {

        Long brandId = 0L;
        if (!brand_id.equals("")) {
            brandId = Long.parseLong(brand_id);
        }

        Brand brand = brandService.GetBrandInfo(brandId);
        model.addAttribute("brand_info", brand);
        return "brand";
    }

    @GetMapping("/{brand_id}") // products of id
    public String GetProductsOfBrand(@PathVariable String brand_id, @RequestParam int page, Model model) {


        return "brandproducts";
    }
}
