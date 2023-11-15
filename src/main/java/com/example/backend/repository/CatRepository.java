package com.example.backend.repository;

import com.example.backend.DTO.CategoryDTO;
import com.example.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Category, Long> {
    @Query("SELECT new com.example.backend.DTO.CategoryDTO(c.category_name, b.brand_name, p.stock, p.cost_price, p.selling_price) " +
            "FROM Category c " +
            "JOIN c.brand b " +
            "JOIN b.product p")
    List<CategoryDTO> fetchCategoryDetails();
}
