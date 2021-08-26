package com.mprog.springapp.service;

import com.mprog.springapp.dao.*;
import com.mprog.springapp.model.Book;
import com.mprog.springapp.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GenreService {

    @Autowired
    private GenreDaoImpl genreDaoImpl;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private GenreRepository genreRepository;


//    @Autowired
//    private BookDao bookDao;
//
//
//    public List<Book> getAll(int id) {
//        return bookDaoImpl.findAllByUserId(id);
//    }
//
//    public int save(Book book) {
//        bookDaoImpl.save(book);
//        return bookDaoImpl.getId(book);
//    }
//
//    public void mapBookAndAuthor(int bookId, int authorId) {
//        bookDaoImpl.mapBookAndAuthor(bookId, authorId);
//    }
//
//    public Book getById(int id) {
//        return bookDao.findById(id).get();
//    }

    public void updateGenre(Genre genre) {
        genreDaoImpl.update(genre);
    }

    public void delete(int id) {
        genreDao.deleteById(id);
    }

    public Page<Genre> findAll(PageRequest of) {
        return genreRepository.findAll(of);
    }

    public void save(Genre genre) {
        genreDao.save(genre);
    }

    public Genre findById(int id) {
        return genreDao.findById(id).get();
    }
}
