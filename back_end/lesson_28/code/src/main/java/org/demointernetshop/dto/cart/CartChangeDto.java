package org.demointernetshop.dto.cart;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CartChange", description = "Cart data for change")
public class CartChangeDto {
    @Schema(description = "Product identifier", example = "14")
    private Integer product_id;
    @Schema(description = "Count of the products", example = "2")
    private Integer count;
}
