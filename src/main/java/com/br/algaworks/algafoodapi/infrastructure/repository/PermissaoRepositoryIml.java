package com.br.algaworks.algafoodapi.infrastructure.repository;

import com.br.algaworks.algafoodapi.domain.model.Permissao;
import com.br.algaworks.algafoodapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Component
public class PermissaoRepositoryIml implements PermissaoRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Permissao> listar() {
        return entityManager.createQuery("from permissao",Permissao.class).getResultList();
    }

    @Override
    public Permissao buscar(Long id) {
        return entityManager.find(Permissao.class,id);
    }

    @Override
    public Permissao salvar(Permissao permissao) {
        return entityManager.merge(permissao);
    }

    @Override
    public void remover(Long id) {
        Permissao permissao = buscar(id);
        entityManager.remove(permissao);
    }
}
