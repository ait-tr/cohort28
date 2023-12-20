package org.demointernetshop.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demointernetshop.dto.product.ProductShortInfoDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "OrderRequest", description = "Order Request data")
public class OrderRequestDto {
    @Schema(description = "Cart identifier", example = "14")
    private Integer cartId;
    @Schema(description = "User identifier", example = "14")
    private Integer userId;
    @Schema(description = "Products")
    private List<ProductShortInfoDto> products;
}
