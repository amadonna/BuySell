package com.example.buysell.services;

import com.example.buysell.models.Image;
import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;

    public List<Product> listProducts(String title) {
        if (title != null) return repository.findByTitle(title);
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.getReferenceById(id);
    }
    public void save(Product product, MultipartFile file1,
                     MultipartFile file2,
                     MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImage(file1);
            image1.setPreviewImage(true);
            product.addImage(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImage(file2);
            product.addImage(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImage(file3);
            product.addImage(image3);
        }
        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDb = repository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        repository.save(product);
    }
    public  void delete(Long id) {
       repository.deleteById(id);
    }

    private Image toImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

}
