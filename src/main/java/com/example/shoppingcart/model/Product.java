package com.example.shoppingcart.model;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private double totalPrice;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
    public int getQuantity() {
        return quantity;
    }

    public double calculateTotalPrice() {
        return price * quantity;

    }
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1200.50, 3);
        System.out.println("Product Name: " + product.name);
        System.out.println("Price per Unit: " + product.price);
        System.out.println("Number of Products: " + product.getQuantity());
        System.out.printf("Total Price: %.2f\n", product.calculateTotalPrice());
    }


}