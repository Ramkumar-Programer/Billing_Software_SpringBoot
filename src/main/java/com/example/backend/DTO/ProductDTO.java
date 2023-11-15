package com.example.backend.DTO;

public class ProductDTO {
    private int stock;
    private double cost_price;
    private double selling_price;

    public ProductDTO(int stock, double cost_price, double selling_price) {
        this.stock = stock;
        this.cost_price = cost_price;
        this.selling_price = selling_price;
    }
    //private double weight;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost_price() {
        return cost_price;
    }

    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
// Constructors, getters, and setters
}