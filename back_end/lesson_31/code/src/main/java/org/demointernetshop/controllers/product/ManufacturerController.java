package org.demointernetshop.controllers.product;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.product.ManufacturerDto;
import org.demointernetshop.services.ManufacturerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping()
    public List<ManufacturerDto> getAllManufacturer(){
        return manufacturerService.getAllManufacturer();
    }


}
