package com.example.lab10;

import com.example.lab10.repository.ProductRepository;
import com.example.lab10.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public ProductService productService(ProductRepository repository) {
        return new ProductService(repository);
    }
}