package com.example.springrest.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepionHandlerController {

	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpRequest request) {
		String error = "Malformed JSON request";
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> runtimeError(RuntimeException runtimeException, HttpStatus status) {
		return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

}
