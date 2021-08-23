package com.mprog.springapp.controller;


import com.mprog.springapp.dao.BookDao;
import com.mprog.springapp.dao.UserDao;
import com.mprog.springapp.model.Author;
import com.mprog.springapp.model.Book;
import com.mprog.springapp.model.User;
import com.mprog.springapp.service.AuthorService;
import com.mprog.springapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @GetMapping("/books")
    public String allBooks(Model model){
        User user = getUser();

        List<Book> books = bookService.getAll(user.getId().intValue());
        model.addAttribute("books", books);

        return "books";
    }


    @GetMapping("/addBook")
    public String add(Model model){

        model.addAttribute("book", new Book());
//        model.addAttribute("author", new Author());
        return "add_book";
    }

    @PostMapping("/books")
    public String add(@ModelAttribute("book") Book book, HttpServletRequest request){

        String authorName = request.getParameter("authorName");
        int authorId = authorService.getAuthorIdByName(authorName);

        User user = getUser();
        book.setUser(user);

        int bookId = bookService.save(book);

        bookService.mapBookAndAuthor(bookId, authorId);

        return "redirect:/books";
    }



    public  User getUser() {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }
        User user = userDao.findByUsername(username);
        return user;
    }
}
