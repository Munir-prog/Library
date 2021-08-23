package com.mprog.springapp.service;

import com.mprog.springapp.dao.BookDao;
import com.mprog.springapp.dao.BookDaoImpl;
import com.mprog.springapp.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookDaoImpl bookDao;


    public List<Book> getAll(int id){
        return bookDao.findAllByName(id);
    }
}
