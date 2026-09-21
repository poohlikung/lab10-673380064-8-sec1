package com.example.lab10.service;

import com.example.lab10.model.Product;
import com.example.lab10.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // ค้นหาสินค้าด้วยรหัสสินค้า
    public Mono<Product> getById(String id) {
        return repository.findById(id);
    }

    // แสดงสินค้าทั้งหมด
    public Flux<Product> getAll() {
        return repository.findAll();
    }

    // เพิ่มหรือแก้ไขสินค้า
    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    // ลบสินค้าด้วยรหัสสินค้า
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    // ค้นหาสินค้าตามหมวดหมู่
    public Flux<Product> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    // คำนวณราคาหลังหักส่วนลด
    public Mono<Double> getDiscountedPrice(String id) {
        return repository.findById(id)
                .map(Product::getDiscountedPrice);
    }
}