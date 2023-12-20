package org.demointernetshop.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ProductShort", description = "Product data")

public class ProductShortResponseDto {
    @Schema(description = "Product identifier", example = "1")
    private Integer id;
    @Schema(description = "Name of the product", example = "iPhone 15")
    private String name;
    @Schema(description = "Description of the product", example = "Latest iPhone model")
    private String description;
    @Schema(description = "Price of the product", example = "1500.0")
    private BigDecimal productPrice;
    @Schema(description = "Quantity of the product", example = "24")
    private Integer productQuantity;
}
