package org.demointernetshop.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Category", description = "Category data")
public class CategoryDto {
    @Schema(description = "Category identifier", example = "1")
    private Integer id;
    @Schema(description = "Name of the Category", example = "smartphones")
    private String categoryName;
}
