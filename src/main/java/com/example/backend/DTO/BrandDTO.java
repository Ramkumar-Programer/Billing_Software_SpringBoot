package com.example.backend.DTO;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {
    private String brand_name;

    public BrandDTO(String brand_name, Integer stock, Double cost_price, Double selling_price) {
        this.brand_name = brand_name;
        // Initialize the products list here
        this.products = new ArrayList<>();
        this.products.add(new ProductDTO(stock, cost_price, selling_price));
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    private List<ProductDTO> products;

    // Constructors, getters, and setters
}