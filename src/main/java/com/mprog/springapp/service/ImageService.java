package com.mprog.springapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class ImageService {

    private static final String IMAGE_FOLDER = "library/";
    private final String basePath = "/home/munir/IdeaProjects/springProjects/library2/src/main/webapp/resources/images";

    public String getImage(MultipartFile file) throws ServletException, IOException {

            String imagePath = IMAGE_FOLDER + file.getOriginalFilename();
            upload(imagePath, file.getInputStream());

            return imagePath;
    }

    private void upload(String imagePath, InputStream inputStream) throws IOException {
        var imageFullPath = Path.of(basePath, imagePath);
        try (inputStream) {
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath, inputStream.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
