package com.coffeestore.service.product;

import com.coffeestore.helpers.OffsetBasedPageRequest;
import com.coffeestore.model.product.Product;
import com.coffeestore.model.rating_product.RatingProduct;
import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.query.repository.ProductRepository;
import com.coffeestore.query.repository.RatingRepository;
import com.coffeestore.query.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository, RatingRepository ratingRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.ratingRepository = ratingRepository;
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

    public Product updateViewProduct(Long productId) {
        Product product = productRepository.getOne(productId);
        product.setCount_views(product.getCount_views() + 1);
        return product;
    }

    public Product addRatingProduct(String userEmail, Long productId, float value) {
        Optional<User> userOptional = userRepository.findByEmail(userEmail);
        if (userOptional.isPresent()) {
            Optional<Product> productOptional = productRepository.findById(productId);

            if (productOptional.isPresent()) {

                RatingProduct ratingProduct = new RatingProduct();
                ratingProduct.setProduct(productOptional.get());
                ratingProduct.setUser(userOptional.get());
                ratingProduct.setValue(value);
                ratingRepository.saveAndFlush(ratingProduct);

                Product product = productOptional.get();
                int count_rating = product.getCount_rating() + 1;
                float rate = (product.getRating_star() + value) / count_rating;
                product.setCount_rating(count_rating);
                product.setRating_star(rate);
                productRepository.save(product);

                return product;
            }
        }
        return new Product();
    }


}
