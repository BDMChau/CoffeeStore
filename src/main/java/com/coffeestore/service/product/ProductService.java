package com.coffeestore.service.product;

import com.coffeestore.helpers.OffsetBasedPageRequest;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.query.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto getProduct(Long productId) {
        Optional<ProductDto> productDtoOptional = productRepository.getProductById(productId);
        return productDtoOptional.orElseGet(ProductDto::new);
    }

    public List<ProductDto> getProducts(Long brandId, int from, int amount) {
        final Pageable pageable = new OffsetBasedPageRequest(from, amount);
        List<ProductDto> productDtoList = productRepository.getProductsByBrandId(brandId, pageable);
        if (productDtoList.isEmpty()) {
            return new ArrayList<>();
        }
        return productDtoList;
    }

    public List<ProductDto> getTopProducts(int req, int from, int amount) {
        final Pageable pageable = new OffsetBasedPageRequest(from, amount);
        switch (req) {
            case 1:
                List<ProductDto> productDtoList = productRepository.getTopProductsByCount_views(pageable);
                if (!productDtoList.isEmpty()) {
                    return productDtoList;
                }
                break;
            case 2:
                productDtoList = productRepository.getTopProductsByRating_star(pageable);
                if (!productDtoList.isEmpty()) {
                    return productDtoList;
                }
                break;
            case 3:
                productDtoList = productRepository.getTopProductsByCount_purchased(pageable);
                if (!productDtoList.isEmpty()) {
                    return productDtoList;
                }
                break;
            default:
                new ArrayList<>();
        }
        return new ArrayList<>();
    }


}
