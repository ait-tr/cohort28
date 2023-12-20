package org.demointernetshop.controllers.product;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.dto.product.ProductQuantityResponseDto;
import org.demointernetshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{category_id}")
    public List<ProductDto> getProductsByCategoryAndPrice(@PathVariable("category_id") Integer categoryId,
                                                          @RequestParam(defaultValue = "0") Double minPrice,
                                                          @RequestParam(defaultValue = "Double.MAX_VALUE") Double maxPrice) {
        return productService.getProductsByCategoryAndPrice(categoryId,minPrice, maxPrice);
    }

    @GetMapping("/category/{category_id}/manufacturer/{manufacturer_id}/price")
    public List<ProductDto> getProductsByCategoryAndManufacturerAndPrice(@PathVariable("category_id") Integer categoryId,
            @PathVariable("manufacturer_id") Integer manufacturerId,
            @RequestParam(defaultValue = "0") Double minPrice,
            @RequestParam(defaultValue = "Double.MAX_VALUE") Double maxPrice) {
        return productService.getProductsByCategoryAndManufacturerAndPrice(categoryId, manufacturerId,minPrice, maxPrice);
    }

    @GetMapping("/{product_id}")
    public ProductDto getProductById(@PathVariable("product_id") Integer productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/{product_id}/quantity")
    public ProductQuantityResponseDto getProductQuantity(@PathVariable("product_id") Integer productId){
        return productService.getProductQuantity(productId);
    }




}
