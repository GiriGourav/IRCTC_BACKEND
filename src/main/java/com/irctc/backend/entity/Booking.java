package com.irctc.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private TrainSchedule trainSchedule;
    private Station sourceStation;
    private Station destinationStation;
    private LocalDate journeyDate;
    private Integer numberOfSeats;
    private BigDecimal totalFare;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    private LocalDateTime createdAt;
    private List<BookingPassenger> passengers;
    private Payment payment;
}
