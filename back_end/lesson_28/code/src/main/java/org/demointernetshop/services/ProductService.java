package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.dto.product.ProductQuantityResponseDto;
import org.demointernetshop.entity.Category;
import org.demointernetshop.entity.Manufacturer;
import org.demointernetshop.entity.Product;
import org.demointernetshop.entity.ProductInfo;
import org.demointernetshop.repository.CategoryRepository;
import org.demointernetshop.repository.ManufacturerRepository;
import org.demointernetshop.repository.ProductInfoRepository;
import org.demointernetshop.repository.ProductRepository;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.demointernetshop.services.utils.Converters;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductInfoRepository productInfoRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final Converters converters;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(converters::fromProductToDto)
                .toList();
    }


    public List<ProductDto> getProductsByCategoryAndPrice(Integer categoryId, Double minPrice, Double maxPrice) {
        return productRepository.findProductsByCategoryAndPrices(categoryId, minPrice, maxPrice).stream()
                .map(converters::fromProductToDto)
                .toList();
    }


    public ProductDto getProductById(Integer productId) {
        return converters.fromProductToDto(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not found!")));
    }

    public ProductQuantityResponseDto getProductQuantity(Integer productId) {
        ProductInfo pi = productInfoRepository.findByProductId(productId).orElseThrow(() -> new RuntimeException("Not found!"));
        return new ProductQuantityResponseDto(pi.getQuantity());
    }

    public List<ProductDto> getProductsByCategoryAndManufacturerAndPrice(Integer categoryId, Integer manufacturerId, Double minPrice, Double maxPrice) {
        return productRepository.findProductsByCategoryAndManufacturer(
                categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Not found!")),
                manufacturerRepository.findById(manufacturerId).orElseThrow(() -> new NotFoundException("Not found!")))
                .stream()
                .filter(product -> product.getProductInfo().getPrice().doubleValue() >= minPrice && product.getProductInfo().getPrice().doubleValue() <= maxPrice)
                .map(converters::fromProductToDto)
                .toList();


    }
}
