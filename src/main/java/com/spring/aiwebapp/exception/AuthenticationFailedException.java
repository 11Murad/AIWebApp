package com.spring.aiwebapp.exception;

public class AuthenticationFailedException extends RuntimeException {
    
    public AuthenticationFailedException(String message) {
        super(message);
    }
    
}
