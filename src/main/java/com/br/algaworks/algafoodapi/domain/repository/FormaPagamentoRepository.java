package com.br.algaworks.algafoodapi.domain.repository;

import com.br.algaworks.algafoodapi.domain.model.FormaPagamento;


import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> listar();
    FormaPagamento buscar(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(Long id);

}
