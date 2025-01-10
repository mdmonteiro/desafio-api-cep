package com.desafioapicep.cepservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.desafioapicep.cepservice.entity.ErrorLog;
import com.desafioapicep.cepservice.repository.ErrorLogRepository;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final ErrorLogRepository errorLogRepository;
    
    public GlobalExceptionHandler(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex, WebRequest request) {
        
        ErrorLog errorLog = new ErrorLog();
        errorLog.setEndpoint(request.getDescription(false));
        errorLog.setErrorMessage(ex.getMessage());
        errorLog.setTimestamp(LocalDateTime.now());
        errorLogRepository.save(errorLog);

       
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Cep não encontrado.");
    }
    
}

