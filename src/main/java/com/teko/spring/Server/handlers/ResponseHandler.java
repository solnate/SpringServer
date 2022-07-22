package com.teko.spring.Server.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        return new ResponseEntity<Object>(responseObj, status);
    }
}
