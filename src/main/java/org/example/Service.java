package org.example;

import org.example.entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Service {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User getUser(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.where(cb.equal(root.get("name"), name));
        cq.select(root);
        TypedQuery<User> q = em.createQuery(cq);
        List<User> resultList = q.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

}
