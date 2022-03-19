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

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/{brand_id}") // products of id
    public String getBrandInfo(@PathVariable String brand_id, Model model) {

        Long brandId = 0L;
        if (!brand_id.equals("")) {
            brandId = Long.parseLong(brand_id);
        }

        Brand brand = brandService.GetBrandInfo(brandId);
        model.addAttribute("brand_info", brand);
        return "brand";
    }

    @GetMapping("/{brand_id}/page") // products of id
    public String getProductsOfBrand(@PathVariable String brand_id, @RequestParam int page, Model model) {

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
}
