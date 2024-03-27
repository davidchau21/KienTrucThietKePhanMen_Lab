package com.example.tuan_1_may2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private long id;
    private String name;
    private int price;
    @ManyToOne
    private User user;

    public Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
