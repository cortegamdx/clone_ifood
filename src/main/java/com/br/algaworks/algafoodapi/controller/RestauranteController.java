package com.br.algaworks.algafoodapi.controller;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.exception.RestauranteNaoExisteException;
import com.br.algaworks.algafoodapi.domain.model.Restaurante;
import com.br.algaworks.algafoodapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("restaurantes")
public class RestauranteController {


    @Autowired
    private CadastroRestauranteService service;


    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(restaurante));

    }
    @PutMapping("{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante){
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.atualizar(id,restaurante));


    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> listar() {
        List<Restaurante> listar = service.listar();

        if (listar.isEmpty()) {
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(listar);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
        Restaurante restaurante = service.buscar(id);

        if (restaurante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(restaurante);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarParcial(@PathVariable("id") Long restauranteId, @RequestBody Map<String,Object> campos){


        Restaurante restauranteAtual = service.buscar(restauranteId);

        if(restauranteAtual== null){
            return ResponseEntity.notFound().build();
        }

        merge(campos,restauranteAtual);


        return ResponseEntity.ok(atualizar(restauranteId,restauranteAtual));
    }

    private static void merge(Map<String, Object> campos,Restaurante restauranteDestino) {
        campos.forEach((k, v) -> {



        });
    }
}
