package com.algaworks.curso.jpa2.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

@ApplicationScoped
public class EntityManagerProducer {

    private EntityManagerFactory factory;

    public EntityManagerProducer() {
        this.factory = createEntityManagerFactory("locadoraVeiculoPU");
    }

    @Produces
    @RequestScoped
    public EntityManager create() {
        return factory.createEntityManager();
    }

    public void close(@Disposes EntityManager manager) {
        manager.close();
    }

}
