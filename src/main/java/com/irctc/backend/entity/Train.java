package com.irctc.backend.entity;

import jakarta.persistence.*;

@Entity
public class Train {

    @Id
    @Column(name = "train_number")
    private String trainNumber;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "route_name")
    private String routeName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TrainImage trainImage;

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

    public TrainImage getTrainImage() {
        return trainImage;
    }

    public void setTrainImage(TrainImage trainImage) {
        this.trainImage = trainImage;
    }
}
