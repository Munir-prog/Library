package com.mprog.springapp.dao;

import com.mprog.springapp.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

import static com.mprog.springapp.dao.SessionFactoryGetter.*;

public class BookDaoImpl {


    public List<Book> findAllByUserId(int id) {

        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<Book> query = currentSession.createQuery("from Book where user_id = :id", Book.class);
        query.setParameter("id", id);
        List<Book> resultList = query.getResultList();

        currentSession.getTransaction().commit();

        return resultList;
    }

    //Check here for 2 query
    public int save(Book book) {
        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.save(book);

        Query<Book> query = currentSession.createQuery("from Book where tittle = :tittle", Book.class);
        query.setParameter("tittle", book.getTittle());
        Book singleBook = query.getSingleResult();

        currentSession.getTransaction().commit();

        return singleBook.getId();
    }

    public void mapBookAndAuthor(int bookId, int authorId) {

        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        String sql = "INSERT INTO book_author (book_id, author_id) VALUES (" + bookId + ", " + authorId + ")";
        Query query = currentSession.createNativeQuery(sql);
//        query.setParameter("b_id", bookId);
//        query.setParameter("a_id", authorId);
        query.executeUpdate();

        currentSession.getTransaction().commit();
    }
}
