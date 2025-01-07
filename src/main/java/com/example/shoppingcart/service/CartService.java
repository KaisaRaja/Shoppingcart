package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.shoppingcart.repository.ProductRepository;

import java.util.List;

@Service
@Transactional

public class CartService {
    private final ProductRepository productRepository;
    private final double TAX_RATE = 22.00;

    public CartService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }
    public void addProduct (Product product){
        productRepository.save(product);

    }
    public List<Product> getCartProducts () {
        return productRepository.findAll();
    }

    public void removeProduct(String id) {
        productRepository.deleteById(Long.valueOf(id));
    }

    public void printProducts () {
        System.out.println(getCartProducts());
    }


    public double calculateTax() {
        return 1 * TAX_RATE / 100;
    }
    //   @Scheduled(fixedRate = 1)
    public double calculateCartTotal(){
        List<Product> products = productRepository.findAll();
        double total = 0;
        for (Product product : products) {
            total += product.calculateTotalPrice();
        }
        System.out.println("Scheduler total : " + (total*calculateTax()));
        return total + (total*calculateTax());
    }
    public double discount(double price) {
        int discount = 0;
        double sale =  price - discount(0);
        return sale;

    }

}