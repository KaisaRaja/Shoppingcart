package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Product;

import java.util.List;

public interface ProductRepository {
    void deleteByName(String name);
    boolean existsByName(String name);
    Product findByName(String name);

    void save(Product product);

    List<Product> findAll();

    void deleteById(Long aLong);
}
