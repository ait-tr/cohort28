package org.fileuploadexample.controller;

import lombok.RequiredArgsConstructor;
import org.fileuploadexample.service.CategoryImageService;
import org.fileuploadexample.service.ProductImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductImageController {

    private final ProductImageService productImageService;

    @GetMapping("/image/{fileName}")
    public ResponseEntity<Resource> getProductImage(@PathVariable String fileName){
        Resource image = productImageService.loadCategoryImage(fileName);

        //Определяем тип содержимого как изображение (например, jpeg)
        MediaType mediaType = MediaType.IMAGE_JPEG;

        //Создаем заголовки для нашего ответа
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        //устанавливаем заголовок Content-Disposition таким образом, чтобы браузер понял,
        // что это вложение (изображение)
        headers.setContentDispositionFormData(fileName, fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .body(image);
    }
}
