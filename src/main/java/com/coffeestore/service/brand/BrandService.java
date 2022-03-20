package com.coffeestore.service.brand;

import com.coffeestore.helpers.OffsetBasedPageRequest;
import com.coffeestore.model.product.Brand;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.query.repository.BrandRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<ProductDto> getProductsByBrand(Long brandId, int from, int amount) {
        Pageable pageable =  new OffsetBasedPageRequest(from, amount);

        List<ProductDto> productDtoList = brandRepository.getProductsByBrandId(brandId,pageable);
        if (productDtoList.isEmpty()){
            return new ArrayList<>();
        }
        return productDtoList;
    }
}
