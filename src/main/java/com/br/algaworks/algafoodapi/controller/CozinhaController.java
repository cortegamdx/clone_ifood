package com.br.algaworks.algafoodapi.controller;

import com.br.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.br.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import com.br.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.br.algaworks.algafoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository repository;

    @Autowired
    private CadastroCozinhaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cozinha>> listar() {

        List<Cozinha> cozinhas = repository.listar();

        if (!cozinhas.isEmpty()) {
            return ResponseEntity.ok(cozinhas);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Cozinha> listarXml() {
        return repository.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
        Cozinha cozinha = repository.buscar(id);
        if (cozinha != null) {
            return ResponseEntity.ok(cozinha);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
        cozinha = repository.salvar(cozinha);

        return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
    }

    @PutMapping("{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinhaAtualizada) {
        Cozinha cozinhaAtual = repository.buscar(cozinhaId);

        if (cozinhaAtual != null) {
            BeanUtils.copyProperties(cozinhaAtualizada, cozinhaAtual, "id");

            service.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {

        try {
            service.excluir(cozinhaId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
