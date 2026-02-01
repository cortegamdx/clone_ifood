package com.br.algaworks.algafoodapi.controller;

import com.br.algaworks.algafoodapi.domain.model.Cidade;
import com.br.algaworks.algafoodapi.domain.service.CadastroCidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cidades")
public class CidadeController {

    @Autowired
    private CadastroCidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade){
        return ResponseEntity.ok(cidadeService.Salvar(cidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar(@RequestBody Cidade cidade, @PathVariable Long id){
        return ResponseEntity.ok(cidadeService.atualizar(cidade,id));
    }
}
