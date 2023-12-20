package org.fileuploadexample.service.util;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LoadFileFromDirectory {

    public Resource load(String directory, String fileName) {
        try {
            Path filePath = Paths.get("src/main/resources/static/upload/" + directory).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Файл не найден: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Ошибка загрузки файла: " + fileName,e);
        }
    }
}
