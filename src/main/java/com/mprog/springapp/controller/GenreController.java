package com.mprog.springapp.controller;

import com.mprog.springapp.dao.GenreDao;
import com.mprog.springapp.dao.GenreRepository;
import com.mprog.springapp.dao.UserDao;
import com.mprog.springapp.model.Book;
import com.mprog.springapp.model.Genre;
import com.mprog.springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class GenreController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genres")
    public String genres(Model model,
                         @RequestParam(value = "page", required = false) Integer pageIndex,
                         @RequestParam(value = "size", required = false) Integer pageSize) {

        if (pageIndex == null) {
            pageIndex = 0;
        }
        if (pageSize == null) {
            pageSize = 3;
        }

        var genrePage = genreRepository.findAll(PageRequest.of(pageIndex, pageSize));
        model.addAttribute("pages", genrePage.getContent());
        model.addAttribute("totalPages", (long) genrePage.getTotalPages());
        model.addAttribute("number", (long) genrePage.getNumber());
        return "genres";
    }

    @GetMapping("/addGenre")
    public String add(Model model) {

        model.addAttribute("genre", new Genre());
        return "add_genre";
    }

    @PostMapping("/genres")
    public String add(@ModelAttribute("genre") Genre genre) throws ServletException, IOException {

        genreDao.save(genre);
        return "redirect:/genres";
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
