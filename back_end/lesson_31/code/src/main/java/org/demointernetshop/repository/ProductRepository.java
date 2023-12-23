package org.demointernetshop.repository;

import org.demointernetshop.model.entity.Category;
import org.demointernetshop.model.entity.Manufacturer;
import org.demointernetshop.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    @Query("SELECT new org.demointernetshop.dto.product.ProductDto(p.id, p.name, p.description, " +
//            "new org.demointernetshop.dto.product.CategoryDto(p.category.id, p.category.categoryName), " +
//            "new org.demointernetshop.dto.product.ManufacturerDto(p.manufacturer.id, p.manufacturer.name, p.manufacturer.country), " +
//            "p.productInfo.price, p.productInfo.quantity) " +
//            "FROM Product p")
//    public List<ProductDto> findAllProductDto();


    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId AND p.productInfo.price BETWEEN :minPrice AND :maxPrice")
    public List<Product>  findProductsByCategoryAndPrices(Integer categoryId, Double minPrice, Double maxPrice);

    public List<Product> findProductsByCategoryAndManufacturer(Category category, Manufacturer manufacturer);


}
