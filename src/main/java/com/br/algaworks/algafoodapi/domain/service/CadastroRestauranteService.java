package com.br.algaworks.algafoodapi.domain.service;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.exception.RestauranteNaoExisteException;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import com.br.algaworks.algafoodapi.domain.model.Restaurante;
import com.br.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.br.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CadastroRestauranteService {


    private final RestauranteRepository repository;

    private final CozinhaRepository cozinhaRepository;

    public Restaurante buscar(Long id) {
        return  repository.buscar(id);
    }

    public List<Restaurante> listar(){
        return repository.listar();
    }


    public Restaurante salvar(Restaurante restaurante){

        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = verificaCozinhaExiste(cozinhaId);

        restaurante.setCozinha(cozinha);

        return repository.salvar(restaurante);
    }
    
    public Restaurante atualizar(Long restauranteId,Restaurante restauranteAtualizado){
        Restaurante restauranteAtual = this.buscar(restauranteId);

        //Restaurante não existe
        if(restauranteAtual == null){
            throw new RestauranteNaoExisteException(String.format("Não existe um restaurante com o id %d",restauranteId));
        }
        //cozinha não existe
        Long cozinhaId = restauranteAtualizado.getCozinha().getId();
        verificaCozinhaExiste(cozinhaId);

        BeanUtils.copyProperties(restauranteAtualizado,restauranteAtual,"id");

        return repository.salvar(restauranteAtual);
    }


    public Cozinha verificaCozinhaExiste(Long idCozinha){
        Cozinha cozinha = cozinhaRepository.buscar(idCozinha);

        if(cozinha == null){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com o codigo %d",idCozinha));
        }

        return cozinha;
    }

}
