package com.bankingappbackend.bankingapp.exception;

import java.time.LocalDateTime;

// since this is a record so the compiler will provide all the boilerplate code
public record ErrorDetails(LocalDateTime timestamp,
                           String message,
                           String details,
                           String errorCode) {
}
