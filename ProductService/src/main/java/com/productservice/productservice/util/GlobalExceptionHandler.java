package com.productservice.productservice.util;

import com.productservice.productservice.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus()
    public ResponseEntity<?> getException(Exception ex)
    {
        log.info("Exception: "+ex.getMessage());
        return new ResponseEntity(new ResponseDto(ex.getMessage(),HttpStatus.BAD_REQUEST.value()),HttpStatus.OK);
    }
}
