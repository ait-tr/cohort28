package org.demointernetshop.dto.product;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Product", description = "Product data")
public class ProductDto {
    @Schema(description = "Product identifier", example = "1")
    private Integer id;
    @Schema(description = "Name of the product", example = "iPhone 15")
    private String name;
    @Schema(description = "Description of the product", example = "Latest iPhone model")
    private String description;
    @Schema(description = "Category of the product")
    private CategoryDto category;
    @Schema(description = "Manufacturer of the product")
    private ManufacturerDto manufacturer;
    @Schema(description = "Price of the product", example = "1500.0")
    private BigDecimal productPrice;
    @Schema(description = "Quantity of the product", example = "24")
    private Integer productQuantity;
}