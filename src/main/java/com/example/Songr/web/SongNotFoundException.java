package com.example.Songr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SongNotFoundException extends RuntimeException{

    public SongNotFoundException() {
    }

    public SongNotFoundException(String message) {
        super(message);
    }
}
