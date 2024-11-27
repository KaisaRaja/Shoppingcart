package controller;

import model.Product;
import org.springframework.web.bind.annotation.*;
import service.CartService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cart")
public class CartController {
    private final CartService service;
    public CartController(CartService service) {
        this.service =service;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return "Product " + product.getName() + " added successfully";

    }
    @GetMapping("/items")
    public List<Product> getCartProducts() {
        return service.getCartProducts();
    }
    @DeleteMapping("/remove/{name}")
    public void removeProduct(@PathVariable String name) {
        service.removeProduct(name);
    }
    @GetMapping("/total")
    public double calculateCartTotal() {
        return service.calculateCartTotal();
    }

}
