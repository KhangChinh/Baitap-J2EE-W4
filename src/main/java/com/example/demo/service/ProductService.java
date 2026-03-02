package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public ProductService() {
        addProduct(new Product(null, "iPhone 15 Pro", 25000000.0, null, Category.DIEN_THOAI));
        addProduct(new Product(null, "MacBook Pro M3", 45000000.0, null, Category.LAPTOP));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(counter.incrementAndGet());
        products.add(product);
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void updateProduct(Product product) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.set(index, product);
        }
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
