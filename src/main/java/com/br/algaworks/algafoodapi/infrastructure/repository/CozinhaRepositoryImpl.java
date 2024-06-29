package com.br.algaworks.algafoodapi.infrastructure.repository;

import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import com.br.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext //poderia usar tbm o @Autowired
    private EntityManager entityManager;

    @Override
    public List<Cozinha> listar(){
        TypedQuery<Cozinha> from_cozinha = entityManager.createQuery("FROM Cozinha", Cozinha.class);
        List<Cozinha> resultList = from_cozinha.getResultList();

        return resultList;
    }
    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha){
        return entityManager.merge(cozinha);
    }

    @Override
    public Cozinha buscar(Long id){
        return  entityManager.find(Cozinha.class,id);
    }

    @Override
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
