package org.fileuploadexample.controller;

import lombok.RequiredArgsConstructor;
import org.fileuploadexample.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    private final FileStorageService fileStorageService;

    @PostMapping("/api/upload")
    public ResponseEntity<String> handleFileUpload(@RequestPart("file") MultipartFile receivedFile){
        try {
            fileStorageService.storeFile(receivedFile);
            return ResponseEntity.status(HttpStatus.OK).body("Файл успешно загружен");
        } catch (Exception e) {
            logger.error("Ошибка при загрузке файла: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при загрузке файла: {}" + e.getMessage());
        }
    }

}
