package com.mprog.springapp.dao;

import com.mprog.springapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {
}
