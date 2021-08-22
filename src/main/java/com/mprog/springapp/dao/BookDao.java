package com.mprog.springapp.dao;

import com.mprog.springapp.model.Book;
import com.mprog.springapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
