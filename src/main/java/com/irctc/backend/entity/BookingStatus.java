package com.irctc.backend.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum BookingStatus {
    PENDING,
    COMPLETED,
    CANCELLED
}
