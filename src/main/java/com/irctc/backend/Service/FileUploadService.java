package com.irctc.backend.Service;

import com.irctc.backend.dto.ImageMetaData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
     ImageMetaData uploadImage(MultipartFile file) throws IOException;
}
