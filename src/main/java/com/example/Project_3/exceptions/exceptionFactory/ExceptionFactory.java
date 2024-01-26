package com.example.Project_3.exceptions.exceptionFactory;

import com.example.Project_3.exceptions.BadRequestException;
import com.example.Project_3.exceptions.PermissionDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExceptionFactory {
    public BadRequestException resourceNotFoundException(String code, String messageConst, String resource, String fieldError, String... values)
            throws BadRequestException {
        StringBuilder builder = new StringBuilder();
        builder.append(resource).append(" ").append(messageConst);
        return new BadRequestException(code, builder.toString(), fieldError, values);
    }
        public PermissionDeniedException permissionDeniedException(String code, String resource, String message) throws PermissionDeniedException {
        return new PermissionDeniedException(code, resource, message);
    }
}
