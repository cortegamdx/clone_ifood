package com.br.algaworks.algafoodapi.infrastructure.repository;

import com.br.algaworks.algafoodapi.domain.model.Restaurante;
import com.br.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public List<Restaurante> listar() {
        return entityManager.createQuery("from restaurante",Restaurante.class).getResultList();
    }

    @Override
    public Restaurante buscar(Long id) {
        return entityManager.find(Restaurante.class,id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return entityManager.merge(restaurante);
    }
    @Transactional
    @Override
    public void remover(Long id) {
        Restaurante restaurante = buscar(id);
        if(restaurante != null){
            remover(id);
            System.out.printf("Restaurante %d - %s removido com sucesso",id,restaurante.getNome());
            return;
        }
        System.out.printf("Restaurante %d - %s não encontrado.",id,restaurante.getNome());
    }
}
