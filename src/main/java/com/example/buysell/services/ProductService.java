package com.example.buysell.services;

import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;

    public List<Product> listProducts(String title) {
        if (title != null) repository.findByTitle(title);
        return repository.findAll();
    }

    public Product getById(Long id) {
        return  repository.getById(id);
    }
    public void save(Product product) {
        log.info("Saving new{}", product);
        repository.save(product);
    }
    public  void delete(Long id) {
       repository.deleteById(id);
    }
}
