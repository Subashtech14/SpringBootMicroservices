package com.aspiresys.productservice.service;

import com.aspiresys.productservice.dto.ProductRequest;
import com.aspiresys.productservice.dto.ProductResponse;
import com.aspiresys.productservice.model.Product;
import com.aspiresys.productservice.repository.ProductRepostiory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepostiory productRepostiory;
    public void createProduct(ProductRequest productRequest){
        Product product =Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepostiory.save(product);
        log.info("Product {} is Saved ",product.getId());


    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepostiory.findAll();
         return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
