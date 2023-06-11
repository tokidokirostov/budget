/*
package com.example.home1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomError {

    private final String message;
    private final String reason;
    private final String status;
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime timestamp = LocalDateTime.now();

    public CustomError(String status, String reason, String message) {
        this.message = message;
        this.reason = reason;
        this.status = status;
    }
}
*/
