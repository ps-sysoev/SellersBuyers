package ru.sysoev.sellersbuyers.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sysoev.sellersbuyers.models.Image;
import ru.sysoev.sellersbuyers.models.Product;
import ru.sysoev.sellersbuyers.repositories.ProductRepository;
import ru.sysoev.sellersbuyers.services.ProductService;
import ru.sysoev.sellersbuyers.util.GenerateImage;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceInDatabaseImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts(String title) {
        if (Objects.nonNull(title)) {
            return productRepository.findByTitle(title);
        }

        return productRepository.findAll();
    }

    @SneakyThrows
    @Override
    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) {
        if (file1.getSize() != 0) {
            Image image1 = GenerateImage.getImageEntity(file1);
            image1.setPreviewImage(true);

            product.addImageToProduct(image1);
        }

        if (file2.getSize() != 0) {
            Image image2 = GenerateImage.getImageEntity(file2);

            product.addImageToProduct(image2);
        }

        if (file3.getSize() != 0) {
            Image image3 = GenerateImage.getImageEntity(file3);

            product.addImageToProduct(image3);
        }

        log.info("Saving new Product: id: {}, title: {}", product.getId(), product.getTitle());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product id={}", id);

        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
