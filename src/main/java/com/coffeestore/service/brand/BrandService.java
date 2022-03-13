package com.coffeestore.service.brand;

import com.coffeestore.model.product.Brand;
import com.coffeestore.query.repository.brand.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand GetBrandInfo(Long brand_id){
        Optional<Brand> brandOptional = brandRepository.findById(brand_id);
        return brandOptional.orElseGet(Brand::new);
    }
}
