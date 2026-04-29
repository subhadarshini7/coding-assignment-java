package com.yourname.rewards.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String code;

    public ErrorResponse(LocalDateTime t, String m, String c) {
        this.timestamp = t;
        this.message = m;
        this.code = c;
    }
}
