package com.creacionpj.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.creacionpj.utils.Constants;

import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@RestControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler (ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException e){
        return problem(HttpStatus.NOT_FOUND, e.getMessage());
    }
    
    @ExceptionHandler (BadRequestException.class)
    public ProblemDetail handleBadRequest(BadRequestException e){
        return problem(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler (Exception.class)
    public ProblemDetail handleGenericException(Exception e){
        log.error(Constants.ERROR_DESCONOCIDO, e);
        return problem(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_DESCONOCIDO);
    }
    
    
    private ProblemDetail problem(HttpStatus status, String mensaje){
        if(mensaje==null|| mensaje.isBlank()){mensaje= Constants.ERROR_DESCONOCIDO;}
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, mensaje);
            pd.setProperty("fecha", LocalDateTime.now());
        return pd;
    }
}
