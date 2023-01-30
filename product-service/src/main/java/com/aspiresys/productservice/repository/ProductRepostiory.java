package com.aspiresys.productservice.repository;

import com.aspiresys.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepostiory extends MongoRepository<Product,String> {
}
