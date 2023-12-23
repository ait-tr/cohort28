package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.product.CategoryDto;
import org.demointernetshop.model.dto.product.CategoryWithPricesDto;
import org.demointernetshop.repository.CategoryRepository;
import org.demointernetshop.repository.ProductInfoRepository;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.demointernetshop.services.utils.Converters;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final Converters converters;
    private final ProductInfoRepository productInfoRepository;

    public List<CategoryDto> getAllCategory(){
        return categoryRepository.findAll().stream()
                .map(converters::formCategoryToDto)
                .toList();
    }

    public CategoryWithPricesDto getCategoryWithPrices(Integer categoryId) {
       /*
       1. Создать объект, который будет содержать id категории, минимальную цену в этой категории, максимальную цену товара в этой категории и название категории
       2. Определить минимальную цену товаров в этой категории
       3. Определить максимальную цену товаров в этой категории
       4. Вытащить название категории из таблицы
        */

//        List<ProductInfo> productInfos = productInfoRepository.findAll();
//
//        BigDecimal minPrice = productInfos.stream()
//                .filter(productInfo -> productInfo.getProduct().getCategory().getId().equals(categoryId))
//                .map(productInfo -> productInfo.getPrice())
//                .min(Comparator.naturalOrder())
//                .orElse(null);
//
//        BigDecimal maxPrice = productInfos.stream()
//                .filter(productInfo -> productInfo.getProduct().getCategory().getId().equals(categoryId))
//                .map(productInfo -> productInfo.getPrice())
//                .max(Comparator.naturalOrder())
//                .orElse(null);
//
//        String categoryName = categoryRepository.findById(categoryId).get().getCategoryName();
//
//        return new CategoryWithPricesDto(categoryId,minPrice,maxPrice, categoryName);


        return productInfoRepository.findPriceByCategory(categoryId)
                .orElseThrow(() -> new NotFoundException("Category not found or no products in the category"));

    }
}
