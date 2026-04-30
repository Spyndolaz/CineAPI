package org.example.cineapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler (MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> tratarValidacao(MethodArgumentNotValidException ex){
            Map<String, String> erros = new HashMap<>();

            ex.getBindingResult().getFieldErrors().forEach(
                    erro -> erros.put(erro.getField(), erro.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(erros);
        }
    }
