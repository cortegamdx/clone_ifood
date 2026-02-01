package com.br.algaworks.algafoodapi.domain.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ExceptionsHandle extends ResponseEntityExceptionHandler {
    
    private final String patternResponse = "[RESPONSE][ERROR] - %s";

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> entidadeEmUsoExceptionHandle(EntidadeEmUsoException e){
        log.error(String.format(patternResponse,e.getMessage()));
       return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> entidadeNaoEncontradaExceptionHandle(EntidadeNaoEncontradaException e) {
        log.error(String.format(patternResponse,e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RestauranteNaoExisteException.class)
    public ResponseEntity<?> restauranteNaoEncontradoExceptionHandle(RestauranteNaoExisteException e){
        log.error(String.format(patternResponse,e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


}
