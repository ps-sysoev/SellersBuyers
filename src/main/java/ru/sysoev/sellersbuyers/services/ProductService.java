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
//    private final List<Product> products = new ArrayList<>();
//    private Long id = 0L;
//
//    {
//        products.add(new Product(++id, "Toyota Rav4", "b/u", 1500000, "Biysk", "Ivan"));
//        products.add(new Product(++id, "Nissan Maxima", "b/u", 1300000, "Biysk", "Petr"));
//        products.add(new Product(++id, "Toyota Land Cruiser 200", "b/u", 2500000, "Biysk", "Vladimir"));
//        products.add(new Product(++id, "Lexus RX330", "b/u", 1350000, "Biysk", "Oleg"));
//        products.add(new Product(++id, "Nissan Tiana", "b/u", 1750000, "Biysk", "Ivan"));
//    }

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
