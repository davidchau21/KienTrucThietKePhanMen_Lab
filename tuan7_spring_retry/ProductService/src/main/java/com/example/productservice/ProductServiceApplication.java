package com.example.productservice;

import com.example.productservice.model.Product;
import com.example.productservice.repositories.ProductRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {
    private final ProductRepository productRepository;
    private final Faker faker = new Faker();

    public ProductServiceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Product product = createFakeProduct();
                productRepository.save(product);
            }
        };
    }

    private Product createFakeProduct() {
        Product product = new Product();
        product.setName(faker.name().fullName());
        product.setPrice(faker.number().randomNumber());
        return product;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
