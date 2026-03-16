package com.example.plataforma_lealtad_spring_azure.exceptions;

import com.example.plataforma_lealtad_spring_azure.exceptions.program.ProgramExistsException;
import com.example.plataforma_lealtad_spring_azure.exceptions.rol.RolExistsException;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private IResponseService iResponseService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> json = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            json.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
    }

    @ExceptionHandler(CreatedEntityException.class)
    public ResponseEntity<?> handleCreatedEntityException(CreatedEntityException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                iResponseService.generateResponse(false, ex.getMessage())
        );
    }
    @ExceptionHandler(ProgramExistsException.class)
    public ResponseEntity<?> handleProgramExistsException(ProgramExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                iResponseService.generateResponse(false, ex.getMessage())
        );
    }

    @ExceptionHandler(RolExistsException.class)
    public ResponseEntity<?> handleRolExistsException(RolExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                iResponseService.generateResponse(false, ex.getMessage())
        );
    }
}
