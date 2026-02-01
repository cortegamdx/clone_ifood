package com.br.algaworks.algafoodapi.domain.service;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.model.Estado;

import com.br.algaworks.algafoodapi.domain.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroEstadoService {


    private final EstadoRepository estadoRepository;


    public Estado salvar(Estado estado){
        return estadoRepository.salvar(estado);
    }

    public Estado buscar(Long id){
        Estado estado = estadoRepository.buscar(id);
        if(estado == null){
            throw  new EntidadeNaoEncontradaException(String.format("Não existe nenhum estado com o id %d",id));
        }
        return estado;
    }

    public List<Estado> listar(){
        return estadoRepository.listar();
    }



    public Estado atualizar(Long estadoId, Estado estado){
        Estado estadoAtual = this.buscar(estadoId);

        if(estadoAtual == null){
            throw  new EntidadeNaoEncontradaException(String.format("Não existe nenhum estado com o id %d",estadoId));
        }

        BeanUtils.copyProperties(estado,estadoAtual,"id");

        return this.salvar(estadoAtual);
    }




}
