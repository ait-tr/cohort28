package org.demointernetshop.services;

import org.demointernetshop.model.dto.product.ProductDto;
import org.demointernetshop.model.entity.product.Product;
import org.demointernetshop.repository.CategoryRepository;
import org.demointernetshop.repository.ManufacturerRepository;
import org.demointernetshop.repository.ProductInfoRepository;
import org.demointernetshop.repository.ProductRepository;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.demointernetshop.services.utils.Converters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest {


    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductInfoRepository productInfoRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ManufacturerRepository manufacturerRepository;

    @Mock
    private Converters converters;

    private List<Product> products;

    @InjectMocks
    private ProductService productService;





    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        products = new ArrayList<>();
        //products.add(new Product(1,""))
    }


    @Test
    public void testAllProducts() {
        // Mockito repository behavior
        when(productRepository.findAll()).thenReturn(products);

        List<ProductDto> result = productService.getAllProducts();
        // verify that the result is an empty list

        assertEquals(0, result.size());
    }

    @Test
    public void testProductById_ExistingID_ReturnsProductDto() {
        // Arrange
        int productId = 1;
        Product mockProduct = new Product(); // создание нового продукта для Mock
        ProductDto mockProductDto = new ProductDto();

        // Mockito repository behavior
        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));
        when(converters.fromProductToDto(mockProduct)).thenReturn(mockProductDto);

        //Выполнение
        ProductDto result = productService.getProductById(productId);

        //Assert
        assertEquals(mockProductDto, result);
    }

    @Test
    public void testProductById_NonExistingID_ThrowsException() {
        // Arrange
        int nonExistingID = 10;

        // Mockito repository behavior
        when(productRepository.findById(nonExistingID)).thenReturn(Optional.empty());

        //Выполнение и сравнение
        // проверить когда вызывается getProductById с несуществующим ID продукта
        // выкинуть NotFoundException
        assertThrows(NotFoundException.class, () -> {productService.getProductById(nonExistingID);
        });
    }


    @Test
    void getProductQuantity() {
    }
}