package com.example.backend.DTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    public CategoryDTO(String category_name, String brand_name, Integer stock, Double cost_price, Double selling_price) {
        this.category_name = category_name;
        // Initialize the brands list here
        this.brands = new ArrayList<>();
        this.brands.add(new BrandDTO(brand_name, stock, cost_price, selling_price));
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<BrandDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandDTO> brands) {
        this.brands = brands;
    }

    private String category_name;
    private List<BrandDTO> brands;

    // Constructors, getters, and setters
}
