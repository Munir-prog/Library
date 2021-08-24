package com.mprog.springapp.service;

import com.mprog.springapp.dao.BookDao;
import com.mprog.springapp.dao.BookDaoImpl;
import com.mprog.springapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookDaoImpl bookDaoImpl;

    @Autowired
    private BookDao bookDao;


    public List<Book> getAll(int id){
        return bookDaoImpl.findAllByUserId(id);
    }

    public int save(Book book) {
        return bookDaoImpl.save(book);
    }

    public void mapBookAndAuthor(int bookId, int authorId) {
        bookDaoImpl.mapBookAndAuthor(bookId, authorId);
    }

    public Book getById(int id) {
        return bookDao.findById(id).get();
    }

    public void updateBook(Book book) {
        bookDaoImpl.update(book);
    }
}
