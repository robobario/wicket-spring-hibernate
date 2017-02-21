package org.example;

import org.example.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class Service {

    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public User getUser(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

}
