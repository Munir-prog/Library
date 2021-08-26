package com.mprog.springapp.dao;


import com.mprog.springapp.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static com.mprog.springapp.dao.SessionFactoryGetter.getSessionFactory;

public class GenreDaoImpl {


    public void update(Genre genre) {
        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.saveOrUpdate(genre);

        currentSession.getTransaction().commit();
    }
}
