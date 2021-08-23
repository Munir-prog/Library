package com.mprog.springapp.dao;

import com.mprog.springapp.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryGetter {

    public static SessionFactory getSessionFactory(){
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
