package com.irctc.backend.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TrainDto {
    @NotEmpty(message = "Train number cannot be null")
    @Size(min = 4, max = 10, message = "Train number must be between 4 and 10 characters")
    @Pattern(regexp = "^[0-9]*$", message = "Train number must be a number")
    @Id
    private String trainNumber;
    @Pattern(regexp = "^[A-Za-z][A-Za-z-]*[A-Za-z]$", message = "Invalid train name, letter, spaces & hyphens are allowed")
    private String trainName;


    private String routeName;
    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
