package com.mprog.springapp.controller;


import com.mprog.springapp.dao.UserDao;
import com.mprog.springapp.model.Book;
import com.mprog.springapp.model.User;
import com.mprog.springapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserDao userDao;

    @GetMapping("/books")
    public String allBooks(Model model){
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }
        User user = userDao.findByUsername(username);

        List<Book> books = bookService.getAll(user.getId().intValue());
        model.addAttribute("books", books);

        return "books";
    }
}
