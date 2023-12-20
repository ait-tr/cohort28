package org.fileuploadexample.service;

import lombok.RequiredArgsConstructor;
import org.fileuploadexample.service.util.LoadFileFromDirectory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class CategoryImageService {

    private final LoadFileFromDirectory loadFileFromDirectory;

    public Resource loadCategoryImage(String fileName) {
        return loadFileFromDirectory.load("category_img", fileName);
    }

}
