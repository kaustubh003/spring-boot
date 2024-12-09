package com.springBootRestApp.crud.service;

import com.springBootRestApp.crud.entity.Product;
import com.springBootRestApp.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public Product saveProduct (Product product) {
        return repository.save(product);
    }

    @Transactional
    public List<Product> saveProducts (List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts () {
        return repository.findAll();
    }

    public Product getProductByID (int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName (String name) {
        return repository.findByName(name);
    }

    @Transactional
    public String deleteProduct (int id) {
        repository.deleteById(id);
        return "Product removed " + id;
    }

    @Transactional
    public Product updateProduct (Product product) {
        int id = product.getId();
        Product existingProduct = repository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct = new Product(product);
            return repository.save(existingProduct);
        }
        return null;
    }
}
