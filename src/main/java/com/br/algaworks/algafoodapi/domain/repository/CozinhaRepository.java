package com.br.algaworks.algafoodapi.domain.repository;

import com.br.algaworks.algafoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);
}
