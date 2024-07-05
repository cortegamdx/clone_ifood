package com.br.algaworks.algafoodapi;

import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import com.br.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CozinhaControler {
    @Autowired
    CozinhaRepository cozinhaRepository;

    @GetMapping("/cozinha")
    public ResponseEntity<List<Cozinha>> listarCozinhas(){

        return  ResponseEntity.ok(cozinhaRepository.listar());
    }
    @GetMapping("/cozinha/{id}")
    public  ResponseEntity<Cozinha> buscar(@PathVariable(name = "id") Long idCozinha){
        Cozinha cozinha = cozinhaRepository.buscar(idCozinha);

        if(cozinha != null){
            return ResponseEntity.ok(cozinha);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cozinha());
    }

}
