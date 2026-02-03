package com.irctc.backend.entity;

import com.irctc.backend.annotations.ValidCoach;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Train {

    @NotEmpty(message = "Train number cannot be null")
    @Size(min = 4, max = 10, message = "Train number must be between 4 and 10 characters")
    private String trainNumber;
    @Pattern(regexp = "^[A-Za-z][A-Za-z-]*[A-Za-z]$", message = "Invalid train name, letter, spaces & hyphens are allowed")
    private String trainName;
    @ValidCoach
    private int coaches;

    public Train(String trainNumber,String trainName, int coaches) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.coaches = coaches;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getCoaches() {
        return coaches;
    }

    public void setCoaches(int coaches) {
        this.coaches = coaches;
    }
}
