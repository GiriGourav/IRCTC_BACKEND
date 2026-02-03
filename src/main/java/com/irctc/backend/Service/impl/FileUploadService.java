package com.irctc.backend.Service.impl;

import com.irctc.backend.dto.ImageMetaData;
import com.irctc.backend.helper.Helper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FileUploadService implements com.irctc.backend.Service.FileUploadService {

    @Value("${file.upload.folder}")
    private String uploadFolder;

    @Override
    public ImageMetaData uploadImage(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        InputStream inputStream=file.getInputStream();
        String folder="uploads/";
//        create folder if not exist
        if(!Files.exists(Paths.get(folder)))
        {
            System.out.println("creating folder");
            Files.createDirectories(Paths.get(folder));
        }
        String fileNameWithPath= Helper.generateFileName(folder,fileName);

        Files.copy(file.getInputStream(), Paths.get(fileNameWithPath), StandardCopyOption.REPLACE_EXISTING);
        ImageMetaData metaData=new ImageMetaData();
        metaData.setFileName(fileNameWithPath);
        metaData.setFileId(UUID.randomUUID().toString());
        metaData.setContentType(file.getContentType());
        metaData.setFileSize(file.getSize());
        metaData.setUploadedAt(LocalDateTime.now());
        return metaData;
    }
}
