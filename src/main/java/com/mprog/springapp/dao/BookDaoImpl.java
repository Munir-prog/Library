package com.mprog.springapp.dao;

import com.mprog.springapp.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class BookDaoImpl {



    public List<Book> findAllByName(int id) {

        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<Book> query = currentSession.createQuery("from Book where user_id = :id", Book.class);
        query.setParameter("id", id);
        List<Book> resultList = query.getResultList();

        currentSession.getTransaction().commit();

        return resultList;
    }

    private static SessionFactory getSessionFactory(){
        return new Configuration()
                .configure()
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Role.class)
                .buildSessionFactory();
    }
}
