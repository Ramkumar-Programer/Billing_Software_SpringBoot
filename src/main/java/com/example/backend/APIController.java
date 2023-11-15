package com.example.backend;

import com.example.backend.DTO.CategoryDTO;
import com.example.backend.entity.Brand;
import com.example.backend.entity.Category;
import com.example.backend.entity.Product;
import com.example.backend.repository.BrandRepository;
import com.example.backend.repository.CatRepository;
import com.example.backend.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", originPatterns = "http://192.168.104.213:3000")

public class APIController
{

    @GetMapping
    public String home()
    {
        return "Home";
    }

    @Autowired
    private CatRepository catRepository;
    @PostMapping("/addCategory")
    public ResponseEntity<String> addCategory(@RequestBody List<Category> catList) {
        try
        {
            for(Category cat : catList)
            {
                Category newCat = new Category();

                newCat.setCategory_name(cat.getCategory_name());

                if(cat.getCategory_id() != null)
                    newCat.setCategory_id(cat.getCategory_id());

                List<Brand> brands = new ArrayList<>();

                if (cat.getBrands() != null)
                {
                    for (Brand brandDTO : cat.getBrands())
                    {
                        Brand brand = new Brand();
                        brand.setBrand_name(brandDTO.getBrand_name());
                        brand.setCategory(newCat);
                        brands.add(brand);
                    }
                }

                newCat.setBrands(brands);
                catRepository.save(newCat);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Categories and Brands added successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
        }
    }


    @GetMapping("/fetchCategory")
    public List<Category> fetchCategory()
    {

        List<Category> data = catRepository.findAll();
        List<Category> datas = new ArrayList<>();

        for (Category cat : data)
        {
            Category myData = new Category();

            myData.setCategory_id(cat.getCategory_id());
            myData.setCategory_name(cat.getCategory_name());

            List<Brand> brandList = new ArrayList<>();

            if (cat.getBrands() != null)
            {
                for (Brand brandDTO : cat.getBrands())
                {
                    Brand brand = new Brand();
                    brand.setBrand_name(brandDTO.getBrand_name());
                    brand.setBrand_id(brandDTO.getBrand_id());
                    brandList.add(brand);
                }
            }

            myData.setBrands(brandList);
            datas.add(myData);
        }

        return datas;
    }
//    @Autowired
//    private CatRepositoryResquest catRepositoryResquest;
//    @GetMapping("/fetchCategory2")
//    public List<CategoryRequest> fetchCategory2()
//    {
//        List<CategoryRequest> data = catRepository.findAll();
//        return data;
//    }
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    private ProductRespository productRespository;
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody List<Product> proList)
    {
        try
        {
            for(Product proData : proList)
            {
                Product product = new Product();
                product.setCost_price(proData.getCost_price());
                product.setSelling_price(proData.getSelling_price());
                product.setStock(proData.getStock());
                Brand brand = brandRepository.findById(proData.getBrand_id()).orElse(null);
                if(brand != null) product.setBrand(brand);
                productRespository.save(product);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/details")
    public List<CategoryDTO> getCategoryDetails() {
        return catRepository.fetchCategoryDetails();
    }
}
