package org.demointernetshop.model.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Category", description = "Category data")
public class CategoryWithPricesDto {
    @Schema(description = "Category identifier", example = "1")
    private Integer id;
    @Schema(description = "minPrice", example = "201")
    private BigDecimal minPrice;
    @Schema(description = "maxPrice", example = "10000")
    private BigDecimal maxPrice;
    @Schema(description = "Name of the Category", example = "smartphones")
    private String categoryName;
}
