package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class FabricanteDAO implements Serializable {

    @Inject
    private EntityManager manager;

    public void save(Fabricante fabricante) {
        manager.persist(fabricante);
    }

    @SuppressWarnings("unchecked")
    public List<Fabricante> buscarTodos() {
        return manager.createQuery("from Fabricante")
                .getResultList();
    }

    @Transactional
    public void excluir(Fabricante fabricante) throws NegocioException {
        fabricante = manager.find(Fabricante.class, fabricante.getCodigo());
        manager.remove(fabricante);
        manager.flush();
    }
}
