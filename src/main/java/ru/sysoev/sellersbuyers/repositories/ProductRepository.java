package ru.sysoev.sellersbuyers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sysoev.sellersbuyers.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
