package ru.sysoev.sellersbuyers.services;

import org.springframework.web.multipart.MultipartFile;
import ru.sysoev.sellersbuyers.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(String title);
    void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3);
    void deleteProduct(Long id);
    Product getProductById(Long id);
}
