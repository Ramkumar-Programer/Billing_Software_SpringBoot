package com.example.backend.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long category_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "total_selling_price")
    private double totalSellingPrice;

    @Column(name = "total_cost_price")
    private double totalCostPrice;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public double getTotalSellingPrice() {
        return totalSellingPrice;
    }

    public void setTotalSellingPrice(double totalSellingPrice) {
        this.totalSellingPrice = totalSellingPrice;
    }

    public double getTotalCostPrice() {
        return totalCostPrice;
    }

    public void setTotalCostPrice(double totalCostPrice) {
        this.totalCostPrice = totalCostPrice;
    }

    public List<Brand> getBrands() {
        return brand;
    }

    public void setBrands(List<Brand> brands) {
        this.brand = brands;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Brand> brand;
}
