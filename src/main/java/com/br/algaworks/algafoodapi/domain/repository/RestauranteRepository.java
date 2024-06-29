package com.br.algaworks.algafoodapi.domain.repository;

import com.br.algaworks.algafoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Long id);
}
