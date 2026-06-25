package com.example.uploadFileDB.exception;

import com.example.uploadFileDB.dto.ErroreDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            FileDBException.class
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErroreDTO handleException(FileDBException e){
        return new ErroreDTO(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
