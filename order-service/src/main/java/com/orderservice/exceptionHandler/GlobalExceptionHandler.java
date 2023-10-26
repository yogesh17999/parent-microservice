package com.orderservice.exceptionHandler;

import com.orderservice.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseBody
    public ErrorMessageDTO getResponseStatusException(ResponseStatusException ex)
    {
        return ErrorMessageDTO.builder().message(ex.getMessage()).status(ex.getStatus().value()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public  ErrorMessageDTO getException(Exception ex)
    {
        return ErrorMessageDTO.builder().
                message(ex.getMessage()).status(HttpStatus.BAD_GATEWAY.value()).build();
    }
}
