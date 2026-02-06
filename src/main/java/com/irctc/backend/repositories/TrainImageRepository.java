package com.irctc.backend.repositories;

import com.irctc.backend.entity.TrainImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainImageRepository extends JpaRepository<TrainImage,String> {
}
