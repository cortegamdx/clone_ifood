package com.br.algaworks.algafoodapi.domain.service;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.model.Cidade;
import com.br.algaworks.algafoodapi.domain.repository.CidadeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCidadeService  {


    private final CadastroEstadoService estadoService;


    private final CidadeRepository cidadeRepository;



    public Cidade Salvar(Cidade cidade){
        estadoService.buscar(cidade.getEstado().getId());

        return cidadeRepository.salvar(cidade);
    }

    public Cidade atualizar(Cidade cidade, Long id){
        Cidade cidadeAtual = buscar(id);

        estadoService.buscar(cidade.getEstado().getId());

        BeanUtils.copyProperties(cidade,cidadeAtual,"id");

        return cidadeRepository.salvar(cidadeAtual);
    }


    public Cidade buscar(Long id){
         Cidade cidade = cidadeRepository.buscar(id);

        if(cidade == null){
            throw new EntidadeNaoEncontradaException("Não existe nenhuma cidade com id - " + id);
        }
        return cidade;
    }

    public void remover(Long id){
        cidadeRepository.remover(id);
    }
}
