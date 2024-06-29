package com.br.algaworks.algafoodapi.jpa.restaurante;

import com.br.algaworks.algafoodapi.domain.model.Restaurante;
import com.br.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import com.br.algaworks.algafoodapi.infrastructure.repository.RestauranteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CadastroRestaurante {

    @Autowired
    RestauranteRepository repository;

    public Restaurante salvar(Restaurante restaurante){
       return repository.salvar(restaurante);
    }

    public List<Restaurante> listar(){
        return repository.listar();
    }
}
