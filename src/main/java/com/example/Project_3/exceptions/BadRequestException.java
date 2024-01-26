package com.example.Project_3.exceptions;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends BaseException{
    public BadRequestException(String code, String message, String fieldError, String... values) {
        super(code, message, fieldError, String.valueOf(values));
    }
}
