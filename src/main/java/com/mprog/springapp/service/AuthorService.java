package com.mprog.springapp.service;

import com.mprog.springapp.dao.AuthorDao;
import com.mprog.springapp.dao.AuthorDaoImpl;
import com.mprog.springapp.dao.BookDaoImpl;
import com.mprog.springapp.model.Author;
import com.mprog.springapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private AuthorDaoImpl authorDaoImpl;

    public List<Author> getAll(int id){
        return authorDaoImpl.findAllByUserId(id);
    }

    public void save(Author author) {
        authorDaoImpl.save(author);
    }

    public int getAuthorIdByName(String authorName) {
        Author author = authorDaoImpl.findAuthorByName(authorName);
        return author.getId();
    }

    public Author getById(int id) {
//        return authorDaoImpl.getById(id);
        return authorDao.findById(id).get();
    }

    public void updateAuthor(Author author) {
        authorDaoImpl.update(author);
    }
}
