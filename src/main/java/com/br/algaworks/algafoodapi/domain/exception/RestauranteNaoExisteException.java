package com.br.algaworks.algafoodapi.domain.exception;

public class RestauranteNaoExisteException extends RuntimeException{

    public RestauranteNaoExisteException(String mensagem) {
        super(mensagem);
    }
}
