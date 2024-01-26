package com.example.Project_3.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException{
    String code;

    String message;

    String fieldError;

    String values;
    public BaseException (String code , String message , String fieldError , String values){
           this.code = code ;
           this.message = message ;
           this.fieldError = fieldError ;
           this.values = values ;
    }

}
