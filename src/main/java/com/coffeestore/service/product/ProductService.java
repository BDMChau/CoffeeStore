package com.coffeestore.service.product;

import com.coffeestore.helpers.OffsetBasedPageRequest;
import com.coffeestore.model.product.Category;
import com.coffeestore.model.product.Product;
import com.coffeestore.model.product.RatingProduct;
import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.query.repository.*;
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
  private final CategoryProductRepository categoryProductRepository;
  private final CategoryRepository categoryRepository;

  public ProductService(ProductRepository productRepository, UserRepository userRepository, RatingRepository ratingRepository, CategoryProductRepository categoryProductRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.userRepository = userRepository;
    this.ratingRepository = ratingRepository;
    this.categoryProductRepository = categoryProductRepository;
    this.categoryRepository = categoryRepository;
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

  public List<ProductDto> getProductsByIds(List listId) {
    List<ProductDto> listToReturn = new ArrayList<>();

    listId.forEach(id -> {
      Optional<ProductDto> productDto = productRepository.getProductById(Long.parseLong(String.valueOf(id)));
      if (!productDto.isEmpty()) {
        listToReturn.add(productDto.get());
      }
    });

    return listToReturn;
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
    Optional<Product> productOptional = productRepository.findById(productId);
    if (productOptional.isPresent()) {
      Product product = productOptional.get();
      long view = product.getCount_views() + 1;
      product.setCount_views(view);
      productRepository.save(product);
      return product;
    }
    return new Product();

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
        Long count_rating = product.getCount_rating() + 1;
        float rate = (product.getRating_star() + value) / count_rating;
        product.setCount_rating(count_rating);
        product.setRating_star(rate);
        productRepository.save(product);

        return product;
      }
    }
    return new Product();
  }

  public List<ProductDto> getRelatedProducts(Long categoryId, int from, int amount) {
    Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
    if (categoryOptional.isPresent()) {
      Pageable pageable = new OffsetBasedPageRequest(from, amount);
      List<ProductDto> productDtoList = productRepository.getProductsByCategoryId(pageable, categoryId);
      if (!productDtoList.isEmpty()) {
        return productDtoList;
      }
    }
    return new ArrayList<>();
  }


}
