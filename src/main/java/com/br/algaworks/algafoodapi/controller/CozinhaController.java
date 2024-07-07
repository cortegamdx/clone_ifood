package com.br.algaworks.algafoodapi.controller;

import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import com.br.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository repository;

    @GetMapping
    public List<Cozinha> listar(){
        return repository.listar();
    }

    @GetMapping("/{id}")
    public Cozinha buscar(@PathVariable Long id){
        return repository.buscar(id);
    }
}
