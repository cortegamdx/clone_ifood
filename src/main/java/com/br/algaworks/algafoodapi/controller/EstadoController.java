package com.br.algaworks.algafoodapi.controller;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.model.Estado;

import com.br.algaworks.algafoodapi.domain.service.CadastroEstadoService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/estados")
public class EstadoController {


    @Autowired
    private CadastroEstadoService service;

    @GetMapping
    public List<Estado> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long idEstado){
            return ResponseEntity.ok(service.buscar(idEstado));
    }

    @PostMapping
    public ResponseEntity<Estado> salvar(@RequestBody Estado estado){

        return  ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> atualizar(@RequestBody Estado estado, @PathVariable long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.atualizar(id,estado));
    }


 
}
