package com.br.algaworks.algafoodapi.jpa;

import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinha {

    //gerencia o contexto de persistencia.
    @PersistenceContext //poderia usar tbm o @Autowired
    private EntityManager entityManager;

    public List<Cozinha> listar(){
        TypedQuery<Cozinha> from_cozinha = entityManager.createQuery("FROM Cozinha", Cozinha.class);
        List<Cozinha> resultList = from_cozinha.getResultList();

        return resultList;
    }

    @Transactional
    public Cozinha adicionar(Cozinha cozinha){
        return entityManager.merge(cozinha);
    }

    public Cozinha buscar(Long id){
        return  entityManager.find(Cozinha.class,id);
    }

    @Transactional
    public void remover(Long id){
        Cozinha cozinha = this.buscar(id);
        if(cozinha != null) {
            entityManager.remove(cozinha);
            System.out.printf("Cozinha  %d - %s removida com sucesso.\n",id,cozinha.getNome());
        }else {
            System.out.printf("Cozinha com id - %d não existe.\n",id);
        }
    }

}
