package com.br.algaworks.algafoodapi.domain.service;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import com.br.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository repository;

    public Cozinha salvar(Cozinha cozinha) {
        return repository.salvar(cozinha);
    }

    public void excluir(Long id) {
        try {
            repository.remover(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso.", id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Cozinha de código %d não existe.", id));
        }
    }
}
