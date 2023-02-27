package com.accenture.util;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {

    public static String readFromFileToString(String filePath) throws IOException {
        return new String(readFromFile(filePath));
    }

    public static byte[] readFromFile(String filePath) throws IOException {
        File resource = new ClassPathResource(filePath).getFile();
        System.out.println(resource.toPath().toAbsolutePath());
        return Files.readAllBytes(resource.toPath());
    }
}