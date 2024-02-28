package com.example.buysell.services;

import com.example.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        products.add(new Product(ID++, "Play Station 5", "Simple description", 6700, "Krasnoyarsk", "Danil"));
        products.add(new Product(ID++, "iPhone 15 Pro Max", "Simple description", 135000, "Kazan", "Bolot"));
    }

    public Product getById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
    public List<Product> listProducts() {
        return products;
    }
    public void save(Product product) {
        product.setId(ID++);
        products.add(product);
    }
    public  void delete(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
