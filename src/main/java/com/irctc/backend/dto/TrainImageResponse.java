package com.irctc.backend.dto;


import com.irctc.backend.entity.TrainImage;

import java.time.LocalDateTime;

public record TrainImageResponse(
        Long id,
        String fileName,
        String fileType,
        String url,
        long size,
        LocalDateTime uploadTime
) {


    public static TrainImageResponse from(TrainImage image, String baseUrl, String trainNo) {
        return new TrainImageResponse(
                image.getId(),
                image.getFileName(),
                image.getFileType(),
                baseUrl + "/" + image.getFileName(),
                image.getSize(),
                image.getUploadTime()
        );
    }

}
