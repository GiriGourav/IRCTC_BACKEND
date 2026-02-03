package com.irctc.backend.dto;

public record ErrorResponse(String message, String code, boolean success) {

}
