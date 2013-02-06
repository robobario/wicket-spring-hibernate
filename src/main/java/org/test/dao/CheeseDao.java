package org.test.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.test.model.Cheese;

import javax.annotation.Resource;

public class CheeseDao {
    @Resource
    SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Cheese getCheese(String name) {
        return (Cheese) sessionFactory.getCurrentSession().createCriteria(Cheese.class).add(Restrictions.eq("name", name)).uniqueResult();
    }
    @Transactional
    public void saveCheese(Cheese cheese) {
        sessionFactory.getCurrentSession().save(cheese);
    }


}
