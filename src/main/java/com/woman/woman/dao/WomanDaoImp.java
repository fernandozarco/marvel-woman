package com.woman.woman.dao;

import com.woman.woman.models.Woman;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class WomanDaoImp implements WomanDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Woman> getWomans() {
        String query = "FROM Woman";
        List<Woman> resultado = entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public void delete(Long id) {
        Woman woman = entityManager.find(Woman.class, id);
        entityManager.remove(woman);
    }

    @Override
    public void create(Woman woman) {
        entityManager.merge(woman);
    }

    @Override
    public boolean checkWoman(Woman woman) {
        String query = "FROM Woman WHERE title = :title AND description = :description";
        List<Woman> lista = entityManager.createQuery(query)
                .setParameter("title", woman.getTitle())
                .setParameter("description", woman.getDescription())
                .getResultList();

        return !lista.isEmpty();
    }
}