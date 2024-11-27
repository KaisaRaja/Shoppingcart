package repository;

import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteByName(String name);
    boolean existsByName(String name);
    Product findByName(String name);

}
