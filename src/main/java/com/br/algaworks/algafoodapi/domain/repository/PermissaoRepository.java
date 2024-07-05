package com.br.algaworks.algafoodapi.domain.repository;

import com.br.algaworks.algafoodapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();
    Permissao buscar(Long id);
    Permissao salvar(Permissao permissao);
    void remover(Long id);

}
