package com.gbourant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class MyService {

    @Inject
    EntityManager em;

    public String createNewEntity() {
        MyEntity e = new MyEntity();
        e.setName("NewName");
        em.persist(e);
        var message = "MyEntity saved with id " + e.getId() + " and version " + e.getVersion();
        System.out.println("message = " + message);
        return message;
    }

    public String editEntity() {
        var e = em.find(MyEntity.class, 1L);
        System.out.println("old version " + e.getVersion());
        e.setVersion(-1);
        e.setName("EditedName " + Math.random());
        em.persist(e);
        em.flush();
        var message = "MyEntity updated with id " + e.getId() + " and version " + e.getVersion();
        System.out.println("message = " + message);
        return message;
    }
}
