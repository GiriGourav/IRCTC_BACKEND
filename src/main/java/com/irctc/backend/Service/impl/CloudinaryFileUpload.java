package com.irctc.backend.Service.impl;

import com.irctc.backend.Service.FileUploadService;
import com.irctc.backend.dto.ImageMetaData;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Primary
public class CloudinaryFileUpload implements FileUploadService {


    @Override
    public ImageMetaData uploadImage(MultipartFile file) throws IOException {
        //        logic to upload the file to cloudinary

        return null;
    }
}
