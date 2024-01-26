package com.example.Project_3.exceptions;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class PermissionDeniedException extends BaseException {


    public PermissionDeniedException(String code, String resource, String message) {
        super(code, message, code, message);
    }
}
