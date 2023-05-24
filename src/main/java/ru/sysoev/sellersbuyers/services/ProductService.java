package ru.sysoev.sellersbuyers.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sysoev.sellersbuyers.models.Product;
import ru.sysoev.sellersbuyers.repositories.ProductRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(String title) {
        if (Objects.nonNull(title)) {
            return productRepository.findByTitle(title);
        }

        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("Saving new {}", product);

        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("Deleting product id={}", id);

        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
