package com.irctc.backend.repositories;

import com.irctc.backend.entity.Train;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainRepository extends JpaRepository<Train, String> {

}
