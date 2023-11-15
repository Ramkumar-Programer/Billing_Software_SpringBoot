package com.example.backend.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long brand_id;

    @Column(name = "brand_name")
    private String brand_name;

    @Column(name = "total_selling_price")
    private double totalSellingPrice;

    @Column(name = "total_cost_price")
    private double totalCostPrice;

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product;

}
