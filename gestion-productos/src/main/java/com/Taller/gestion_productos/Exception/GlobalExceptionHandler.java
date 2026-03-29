package com.Taller.gestion_productos.Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(ProductoNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }  
}
