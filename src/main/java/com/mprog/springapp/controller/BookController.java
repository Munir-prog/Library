package com.mprog.springapp.controller;


import com.mprog.springapp.dao.BookDao;
import com.mprog.springapp.dao.BookRepository;
import com.mprog.springapp.dao.UserDao;
import com.mprog.springapp.model.Author;
import com.mprog.springapp.model.Book;
import com.mprog.springapp.model.User;
import com.mprog.springapp.service.AuthorService;
import com.mprog.springapp.service.BookService;
import com.mprog.springapp.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserDao userDao;


    @GetMapping("/books")
    public String allBooks(Model model,
                           @RequestParam(value = "page", required = false) Integer pageIndex,
                           @RequestParam(value = "size", required = false) Integer pageSize) {
        User user = getUser();

        if (pageIndex == null) {
            pageIndex = 0;
        }
        if (pageSize == null) {
            pageSize = 3;
        }

        Page<Book> pageBook = bookService.findByUserId(user.getId(), PageRequest.of(pageIndex, pageSize));
        model.addAttribute("pages", pageBook.getContent());
        model.addAttribute("totalPages", (long) pageBook.getTotalPages());
        model.addAttribute("number", (long) pageBook.getNumber());
        return "books";
    }

    @GetMapping("/addBook")
    public String add(Model model) {

        model.addAttribute("book", new Book());
        return "add_book";
    }


    @PostMapping("/books")
    public String add(@ModelAttribute("book") Book book, @RequestParam("bookImage") MultipartFile file, HttpServletRequest request) throws ServletException, IOException {

        User user = getUser();
        String image = imageService.getImage(file);
        String authorName = request.getParameter("authorName");
        int authorId = authorService.getAuthorIdByName(authorName);

        book.setImage(image);
        book.setUser(user);

        int bookId = bookService.save(book);

        bookService.mapBookAndAuthor(bookId, authorId);

        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String show(@PathVariable("id") int id, Model model) {

        Book book = bookService.getById(id);
        model.addAttribute("book", book);

        return "book";
    }

    @GetMapping("/books/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        var book = bookService.getById(id);
        model.addAttribute("book", book);
        return "edit_book";
    }

    @PostMapping("/bookEdit/{id}")
    public String edit(@ModelAttribute("book") Book book, @PathVariable("id") int id, @RequestParam("bookImage") MultipartFile file) throws ServletException, IOException {
        var user = getUser();
        String image = imageService.getImage(file);
        book.setImage(image);
        book.setUser(user);
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }


    public User getUser() {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        User user = userDao.findByUsername(username);
        return user;
    }
}

