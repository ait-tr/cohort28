package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.product.ManufacturerDto;
import org.demointernetshop.repository.ManufacturerRepository;
import org.demointernetshop.services.utils.Converters;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final Converters converters;
    public List<ManufacturerDto> getAllManufacturer() {
        return converters.fromManufacturerToDtos(manufacturerRepository.findAll());
    }
}
