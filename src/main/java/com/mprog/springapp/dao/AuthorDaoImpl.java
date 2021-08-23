package com.mprog.springapp.dao;

import com.mprog.springapp.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

import static com.mprog.springapp.dao.SessionFactoryGetter.getSessionFactory;

public class AuthorDaoImpl {



    public List<Author> findAllByUserId(int id) {

        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<Author> query = currentSession.createQuery("from Author where user_id = :id", Author.class);
        query.setParameter("id", id);
        List<Author> resultList = query.getResultList();

        currentSession.getTransaction().commit();

        return resultList;
    }


    public void save(Author author) {

        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.save(author);
//        Query<Author> query = currentSession.createQuery("from Author where user_id = :id", Author.class);
//        query.setParameter("id", id);
//        List<Author> resultList = query.getResultList();

        currentSession.getTransaction().commit();
    }

    public Author findAuthorByName(String authorName) {
        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<Author> query = currentSession.createQuery("from Author where name = :name", Author.class);
        query.setParameter("name", authorName);
        Author author = query.getSingleResult();

        currentSession.getTransaction().commit();

        return author;
    }
}
