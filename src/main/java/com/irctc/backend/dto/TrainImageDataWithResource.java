package com.irctc.backend.dto;

import com.irctc.backend.entity.TrainImage;
import org.springframework.core.io.Resource;

public record TrainImageDataWithResource(
        TrainImage trainImage,
        Resource resource
) {
}
