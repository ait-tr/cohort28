package org.demointernetshop.model.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Product Short Info", description = "Product shot data")
public class ProductShortInfoDto {
    @Schema(description = "Product identifier", example = "1")
    private Integer id;
    @Schema(description = "Name of the product", example = "iPhone 15")
    private String name;
    @Schema(description = "Price of the product", example = "1500.0")
    private BigDecimal price;
    @Schema(description = "Quantity of the product", example = "24")
    private Integer quantity;
}
