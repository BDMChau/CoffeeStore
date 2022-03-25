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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String GetBrandInfo(Model model) {
        Brand TN_info = brandService.GetBrandInfo(1L);
        Brand VINA_info = brandService.GetBrandInfo(2L);
        Brand NEST_info = brandService.GetBrandInfo(3L);
        Brand random = brandService.GetBrandInfo(5L);


        List<ProductDto> TN_products = brandService.getProductsByBrand(TN_info.getId());
        List<ProductDto> VINA_products = brandService.getProductsByBrand(VINA_info.getId());
        List<ProductDto> NEST_products = brandService.getProductsByBrand(NEST_info.getId());
        List<ProductDto> random_products = brandService.getProductsByBrand(random.getId());

        model.addAttribute("TN_products", TN_products);
        model.addAttribute("VINA_products", VINA_products);
        model.addAttribute("NEST_products", NEST_products);
        model.addAttribute("random_products", random_products);


        List<Brand> brands_info = new ArrayList();
        brands_info.add(TN_info);
        brands_info.add(VINA_info);
        brands_info.add(NEST_info);
        brands_info.add(random);

        model.addAttribute("brands_info", brands_info);

        return "brand";
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
            model.addAttribute("list_product", productDtoList);
            return "brandproducts";
    }
}
