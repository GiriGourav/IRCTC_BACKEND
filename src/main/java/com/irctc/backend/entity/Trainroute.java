package com.irctc.backend.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Locale;

@Entity
@Table(name = "train_routes")
public class Trainroute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    private Integer stationOrder;

    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private Integer haltMinutes;
    private Integer distanceFromSource;
    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
}
