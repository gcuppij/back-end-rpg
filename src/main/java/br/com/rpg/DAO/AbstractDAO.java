package br.com.rpg.DAO;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AbstractDAO<T> {

    @Inject
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Integer save(T app) {
        return (Integer) getCurrentSession().save(app);
    }

    public void delete(T app) {
        getCurrentSession().delete(app);
    }

}